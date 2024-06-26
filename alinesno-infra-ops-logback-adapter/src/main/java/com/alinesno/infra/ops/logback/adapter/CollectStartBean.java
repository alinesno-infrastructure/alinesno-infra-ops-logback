package com.alinesno.infra.ops.logback.adapter;

import com.alinesno.infra.ops.logback.adapter.collect.KafkaCollect;
import com.alinesno.infra.ops.logback.adapter.collect.RedisCollect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(100)
public class CollectStartBean implements InitializingBean {

    @Value("${alinesno.ops.logback.model:redis}")
    private String model ;

    @Autowired
    private KafkaCollect kafkaLogCollect ;

    @Autowired
    private RedisCollect redisCollect ;

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            serverCollect();
        } catch (Exception e) {
            log.error("collect logback server starting failed!", e);
        }
    }

    private void serverCollect() {
        if(model.equals("kafka")){
            kafkaLogCollect.kafkaStart();
        }else if(model.equals("redis")){
            redisCollect.redisStart();
        }
    }
}