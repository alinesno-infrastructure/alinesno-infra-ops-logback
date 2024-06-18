package com.alinesno.infra.ops.logback.core;

import com.alinesno.infra.ops.logback.core.client.AbstractClient;
import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import com.alinesno.infra.ops.logback.core.dto.RunLogCompressMessage;
import com.alinesno.infra.ops.logback.core.exception.LogQueueConnectException;
import com.alinesno.infra.ops.logback.core.utils.GfJsonUtil;
import com.alinesno.infra.ops.logback.core.utils.HttpClient;
import com.alinesno.infra.ops.logback.core.utils.LZ4Util;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * className：MessageAppenderFactory
 * description：该类提供了将日志消息添加到队列中的功能
 *
 * @author Tank
 * @author luoxiaodong
 * @version 1.0.0
 */
public class MessageAppenderFactory {

    /**
     * 当下游异常的时候，状态缓存时间
     */
    private final static Cache<String, Boolean> cache = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.SECONDS).build();

    public static BlockingQueue<String> rundataQueue;
    public static int queueSize = 10000;

    private static Boolean logOutPut = true;
    private static final AtomicLong lastRunPushTime = new AtomicLong(0);

    public static void initQueue(int logQueueSize) {
        queueSize = logQueueSize;
        if (rundataQueue == null) {
            rundataQueue = new LinkedBlockingQueue<>(logQueueSize);
        }
    }


    public static void pushRundataQueue(String message) {
        if (message != null) {
            if (rundataQueue.size() < queueSize) {
                rundataQueue.add(message);
            }
        }
    }

    public static void push(String key, List<String> baseLogMessage, AbstractClient client, String logOutPutKey, boolean compress) {
        Boolean logOutPut = cache.getIfPresent(logOutPutKey);
        if (logOutPut == null || logOutPut) {
            try {
                client.putMessageList(key, compress(baseLogMessage, compress));
                cache.put(logOutPutKey, true);
            } catch (LogQueueConnectException e) {
                cache.put(logOutPutKey, false);
                System.out.println("infraLog error:----------------"+e.getMessage()+"-------------------");
            }
        }
    }

    private static List<String> compress(List<String> baseLogMessage, boolean compress) {

        if (!compress) {
            return baseLogMessage;
        }
        String text = GfJsonUtil.toJSONString(baseLogMessage);
        byte[] textByte = text.getBytes(StandardCharsets.UTF_8);
        byte[] compressedByte = LZ4Util.compressedByte(textByte);
        RunLogCompressMessage message = new RunLogCompressMessage();
        message.setBody(compressedByte);
        message.setLength(textByte.length);
        return Lists.newArrayList(GfJsonUtil.toJSONString(message));
    }

    public static void startRunLog(AbstractClient client, int maxCount) {
        startRunLog(client, maxCount, MessageConstant.LOG_KEY_LOGGER);
    }

    public static void startRunLog(AbstractClient client, int maxCount, String key) {
        startRunLog(client, maxCount, key, false);
    }

    public static void startRunLog(AbstractClient client, int maxCount, String key, boolean compress) {
        while (true) {
            try {
            	System.out.println("输出日志: maxCount:" + maxCount+ " , key:" + key +" , comporess:" + compress);
                doStartLog(client, maxCount, rundataQueue, key, "plume.log.ack", lastRunPushTime, compress);
            } catch (Exception e) {
                System.out.println("infraLog error:----------------"+e.getMessage()+"-------------------");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                }
            }
        }
    }

    private static void doStartLog(AbstractClient client, int maxCount, BlockingQueue<String> queue, String key, String lock, AtomicLong pushTime, boolean compress) throws InterruptedException {

        List<String> logs = new ArrayList<>();

        int size = queue.size();
        long currentTimeMillis = System.currentTimeMillis();
        long time = currentTimeMillis - pushTime.get();

        if (size >= maxCount || time > 500) {
            queue.drainTo(logs, maxCount);
            push(key, logs, client, lock, compress);
            pushTime.set(currentTimeMillis);
        } else if (size == 0) {
            String log = queue.take();
            logs.add(log);
            push(key, logs, client, lock, compress);
            pushTime.set(currentTimeMillis);
        } else {
            Thread.sleep(100);
        }
    }

    public static void startRunLog(String loggerHost, int maxCount, String key, boolean compress) {
        while (true) {
            try {
                doStartLog(loggerHost, maxCount, rundataQueue, key, "plume.log.ack", lastRunPushTime);
            } catch (Exception e) {
                String exMsg=e.getMessage();
                System.out.println("ops-logback error:--------doStartLog--------"+exMsg+"-------------------");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }


    private static void doStartLog(String loggerHost, int maxCount, BlockingQueue<String> queue, String key, String lock, AtomicLong pushTime) throws InterruptedException {

        List<String> logs = new ArrayList<>();

        int size = queue.size();
        long currentTimeMillis = System.currentTimeMillis();
        long time = currentTimeMillis - pushTime.get();

        if (size >= maxCount || time > 500) {
            queue.drainTo(logs, maxCount);

            push(loggerHost, key, logs, lock);

            pushTime.set(currentTimeMillis);
        } else if (size == 0) {
            String log = queue.take();
            logs.add(log);

            push(loggerHost, key, logs, lock);

            pushTime.set(currentTimeMillis);
        } else {
            Thread.sleep(100);
        }
    }

    private static void push(String loggerHost, String key, List<String> baseLogMessage, String logOutPutKey) {
        if (baseLogMessage.isEmpty()) {
            return;
        }

        List<Map<String,Object>> logs=new ArrayList<>();
        for(String str:baseLogMessage){
            Map<String, Object> map = GfJsonUtil.parseObject(str, Map.class);
            logs.add(map);
        }

        logOutPut = cache.getIfPresent(logOutPutKey);
        if (logOutPut == null || logOutPut) {
            try {

                String path = "v1/api/collector/logRest";
                String url = loggerHost.endsWith("/") ? loggerHost + path : loggerHost + "/" + path ;

                String param = GfJsonUtil.toJSONString(logs);
                System.out.println("url = " + url + " , 消息内容:" + param);

                HttpClient.doPostBody(url, param);

                cache.put(logOutPutKey, true);

            } catch (Exception e) {
                cache.put(logOutPutKey, false);
                System.out.println("logger error:----------------"+e.getMessage()+"-------------------");
            }
        }
    }


}
