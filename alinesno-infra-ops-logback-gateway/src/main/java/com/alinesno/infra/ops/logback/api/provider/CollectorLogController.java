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

    @Value("${alinesno.logback.model:redis}")
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


    @PostMapping("/logRest")
    public AjaxResult logRest(@RequestBody String message){

        log.debug("logRest message = {}" , message);

        Map<String, String> messageMap = new HashMap<>();
        messageMap.put(MessageConstant.REDIS_REST_KEY , message);

        RecordId recordId = redisTemplate.opsForStream().add(MessageConstant.REDIS_REST_KEY , messageMap);
        if (recordId != null) {
            log.info("Message sent to Stream topic:{} with RecordId:{}"  , MessageConstant.REDIS_REST_KEY , recordId);
        }

        return AjaxResult.success(model) ;
    }

}
