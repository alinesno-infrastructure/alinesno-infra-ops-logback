package com.alinesno.infra.ops.logback.consumer.collect;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import com.alinesno.infra.ops.logback.core.dto.RunLogMessage;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;

import com.alibaba.fastjson.JSON;

/**
 * Kafka日志采集，保存到clickhouse当中
 * @author luoxiaodong
 * @version 1.0.0
 */
public class KafkaLogCollect extends BaseLogCollect {
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(KafkaLogCollect.class);

	int count = 0 ; 
	
	private final KafkaConsumer<String, String> kafkaConsumer;

	public KafkaLogCollect( KafkaConsumer<String , String> kafkaConsumer,  ApplicationEventPublisher applicationEventPublisher) {

		this.kafkaConsumer = kafkaConsumer;
		logger.debug("kafkaConsumer = {}", kafkaConsumer);

		// 监听的topic
		this.kafkaConsumer.subscribe(Arrays.asList(
				MessageConstant.LOG_KEY_LOGGER,
				MessageConstant.LOG_KEY_TRACE ,
				MessageConstant.LOG_KEY_COMPRESS));
		
		super.applicationEventPublisher = applicationEventPublisher;
		logger.info("kafkaConsumer subscribe ready!");
		logger.info("sending log ready!");
	}

	public void kafkaStart() {
		threadPoolExecutor.execute(this::collectRuningLog);
		logger.info("KafkaLogCollect is starting!");
	}

	public void collectRuningLog() {
		while (true) {
			List<String> logList = new ArrayList<String>();

			try {
				ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));

				records.forEach(record -> {
						
					if (logger.isDebugEnabled()) {
						logger.debug("get log:" + record.value() + "  logType:" + record.topic());
						logger.debug("count = {}" , count++) ;
					}

					// 后端日志
					if (record.topic().equals(MessageConstant.LOG_KEY_LOGGER)) {

						String logString = record.value();
						RunLogMessage runLogMessage = JSON.parseObject(logString, RunLogMessage.class);

						logList.add(logString);
					}
				});
			} catch (Exception e) {
				logger.error("get logs from kafka failed! ", e);
			}

			// 业务日志
			if (!logList.isEmpty()) {
				super.sendLog(logList);
				publisherMonitorEvent(logList);
			}

		}
	}

}
