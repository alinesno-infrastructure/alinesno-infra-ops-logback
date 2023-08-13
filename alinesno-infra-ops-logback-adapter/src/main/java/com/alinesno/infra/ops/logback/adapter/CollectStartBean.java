package com.alinesno.infra.ops.logback.adapter;

import com.alinesno.infra.ops.logback.adapter.collect.KafkaCollect;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(100)
public class CollectStartBean implements InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(CollectStartBean.class) ;

    @Autowired
    private KafkaCollect kafkaLogCollect ;

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            serverCollect();
        } catch (Exception e) {
            log.error("collect logback server starting failed!", e);
        }
    }

    private void serverCollect() {
        kafkaLogCollect.kafkaStart();
    }
}