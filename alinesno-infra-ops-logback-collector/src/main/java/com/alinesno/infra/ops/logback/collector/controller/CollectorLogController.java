package com.alinesno.infra.ops.logback.collector.controller;

import com.alinesno.infra.common.facade.response.AjaxResult;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 采集日志服务
 */
@RequestMapping("/v1/api/collector")
public class CollectorLogController {

    public static final Logger log = LoggerFactory.getLogger(CollectorLogController.class) ;

    @PostMapping("/logEntity")
    public AjaxResult logEntity(String topic, String message){

        KafkaProducer<String , String> kafkaProducer = null ;
        try {
            kafkaProducer.send(new ProducerRecord<>(topic, message));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            kafkaProducer.close();
        }

        return AjaxResult.success() ;
    }

}
