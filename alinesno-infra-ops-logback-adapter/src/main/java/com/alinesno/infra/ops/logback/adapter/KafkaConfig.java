package com.alinesno.infra.ops.logback.adapter;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaConfig {

    private static final Logger log = LoggerFactory.getLogger(KafkaConfig.class) ;

    /**
     * 初始化一个 kafkaConsumer 对象，并作为 Bean 注入到 Spring 管理的对象中
     * @return kafkaConsumer 实例
     */
    @Bean
    KafkaConsumer<String , String> kafkaConsumer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.101.18:9092");
        props.put("group.id", "1");

        //配置自动提交offset
        props.put("enable.auto.commit", "true");
        //配置自动提交offset的时间间隔为1秒
        props.put("auto.commit.interval.ms", "1000");

        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        log.info("KafkaConsumer  init finished") ;

        return consumer;
    }
}

