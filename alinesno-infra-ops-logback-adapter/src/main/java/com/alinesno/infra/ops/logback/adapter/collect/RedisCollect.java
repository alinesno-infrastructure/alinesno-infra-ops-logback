package com.alinesno.infra.ops.logback.adapter.collect;

import com.alibaba.fastjson.JSON;
import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import com.alinesno.infra.ops.logback.core.dto.RunLogCompressMessage;
import com.alinesno.infra.ops.logback.core.utils.GfJsonUtil;
import com.alinesno.infra.ops.logback.core.utils.LZ4Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.Consumer;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.ReadOffset;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Redis日志采集，保存到postgresql当中
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@Component
public class RedisCollect extends BaseLogCollect {

    private final boolean compressor = true ;

    //最大每次发送日志条数
    public static int MAX_SEND_SIZE = 5000;

    //日志抓取频次间隔时间
    public static int MAX_INTERVAL = 3000;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void redisStart() {
        Thread runLogThread = startRunLogThread();

        scheduledThreadPoolExecutor.scheduleWithFixedDelay(() -> {
            Thread runLog = runLogThread;
            try {
                boolean runLogThreadAlive = runLog.isAlive();
                if (!runLogThreadAlive) {
                    throw new NullPointerException("runLogThread alive false");
                }
            } catch (Exception ex) {
                System.out.println("runLogThread 重启线程");
                runLog = startRunLogThread();
            }

        }, 10, 30, TimeUnit.SECONDS);

        log.info("RedisLogCollect is starting!");
    }

    private Thread startRunLogThread() {
        Thread runLogThread = new Thread(this::collectRunningLog);
        runLogThread.start();
        return runLogThread;
    }

    private void collectRunningLog() {
        while (true) {
            List<String> logs = new ArrayList<>();

            log.debug("redis collect running log!!");

            try {
                Thread.sleep(MAX_INTERVAL);
            } catch (InterruptedException e) {
                log.error("", e);
                Thread.currentThread().interrupt();
            }

            String streamKey = MessageConstant.REDIS_REST_KEY ;
            String groupName = "app_group";
            String consumerName = "app_consumer_" ;

            // 创建消费者组
            try {
                redisTemplate.opsForStream().createGroup(streamKey, groupName);
            } catch (Exception e) {
                // 组可能已经存在，忽略异常
            }

            // 读取并处理消息
            List<MapRecord<String, Object, Object>> messages = redisTemplate.opsForStream()
                    .read(Consumer.from(groupName, consumerName),
                            StreamOffset.create(streamKey, ReadOffset.lastConsumed()));

            if(messages != null && !messages.isEmpty()){
                for (MapRecord<String, Object, Object> message : messages) {

                    log.debug("message = {}" , message);

                    // 处理消息逻辑
                    logs.add(message.getValue().toString()) ;
                    // 确认消息
                    redisTemplate.opsForStream().acknowledge(streamKey, groupName, message.getId());
                }

                super.handleLog(logs) ;
                publisherMonitorEvent(logs);
            }

        }
    }

    private List<String> decompressor(List<String> logs) {
        if (!compressor) {
            return logs;
        }
        int size = logs.size();
        List<String> list = new ArrayList<>();
        if (!logs.isEmpty()) {
            for (int i = 0; i < logs.size(); i++) {
                String r = logs.get(i);
                try {
                    RunLogCompressMessage message = JSON.parseObject(r, RunLogCompressMessage.class);
                    byte[] bytes = LZ4Util.decompressorByte(message.getBody(), message.getLength());
                    String json = new String(bytes);
                    list.addAll(GfJsonUtil.parseArray(json, String.class));
                } catch (Exception e) {
                    log.error("解析日志失败！", e);
                }
            }
        }
        return list;
    }

}
