package com.alinesno.infra.ops.logback.api.provider;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 采集日志服务
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@RequestMapping("/v1/api/collector")
@RestController
public class CollectorLogController {

    @Value("${alinesno.ops.logback.model:redis}")
    private String model ;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/logMq")
    public AjaxResult logMq(String topic, String message){

        if(model.equals("kafka")){
            KafkaProducer<String , String> kafkaProducer = null ;
            try {
                kafkaProducer.send(new ProducerRecord<>(topic, message));
            } catch (Exception e) {
                log.error("发送日志服务异常:{}" , e.getMessage());
            } finally {
                kafkaProducer.close();
            }
        }else if(model.equals("redis")){
            Map<String, String> messageMap = new HashMap<>();
            messageMap.put(topic, message);

            RecordId recordId = redisTemplate.opsForStream().add(topic, messageMap);
            if (recordId != null) {
                log.info("Message sent to Stream topic:{} with RecordId:{}"  , topic, recordId);
            }
        }

        return AjaxResult.success(model) ;
    }


    @PostMapping("/runningLog")
    public AjaxResult logRest(@RequestBody String message){
        sendRedisQueue(message , MessageConstant.REDIS_REST_RUNNINGLOG_KEY);
        return AjaxResult.success(model) ;
    }


    /**
     * 接收业务日志并将其存储到Redis流中。
     *
     * @param message 业务日志信息，以字符串形式传入。
     * @return 返回操作结果，成功则包含模型信息。
     *
     */
    @PostMapping("/businessLog")
    public AjaxResult businessLog(@RequestBody String message){
        sendRedisQueue(message , MessageConstant.REDIS_REST_BUSINESS_KEY);
        return AjaxResult.success(model) ;
    }


    /**
     * 将数据库操作日志信息发送到Redis队列
     *
     * @param message 数据库操作日志信息
     * @return AjaxResult 返回操作结果，成功则包含模型数据
     */
     @PostMapping("/databaseLog")
    public AjaxResult databaseLog(@RequestBody String message){
        // 将日志信息发送到Redis队列，队列键名为REDIS_REST_DATABASE_KEY定义的值
        sendRedisQueue(message , MessageConstant.REDIS_REST_DATABASE_KEY);
        // 返回操作成功的Ajax结果，包含模型数据
        return AjaxResult.success(model) ;
    }

    /**
     * 将消息发送到Redis流中。
     *
     * 此方法用于将给定的消息封装到一个Map中，并通过Redis流将其发送出去。
     * 使用Redis流可以实现消息的可靠传输和存储，适用于消息队列或事件驱动架构。
     *
     * @param message 消息内容，作为流中的值。
     * @param key Redis流的键，用于标识特定的流。
     */
    private void sendRedisQueue(String message , String key) {
        // 使用DEBUG级别日志记录消息内容，用于调试和日志记录。
        log.debug("sendRedisQueue logRest message = {}" , message);

        // 创建一个Map来存储消息，其中key为消息键，message为消息值。
        Map<String, Object> messageMap = new HashMap<>();
        messageMap.put(key , message);

        // 将消息添加到Redis流中，返回记录的ID。
        RecordId recordId = redisTemplate.opsForStream().add(key , messageMap);
        // 使用INFO级别日志记录消息发送的成功事件和记录ID，用于监控和日志记录。
        if (recordId != null) {
            log.info(key + " Message sent to Stream topic:{} with RecordId:{}"  , key , recordId);
        }
    }

}
