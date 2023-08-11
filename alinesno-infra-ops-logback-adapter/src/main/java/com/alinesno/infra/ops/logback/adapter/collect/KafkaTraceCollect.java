package com.alinesno.infra.ops.logback.adapter.collect;

import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Kafka日志采集，保存到clickhouse当中
 * @author luoxiaodong
 * @version 1.0.0
 */
public class KafkaTraceCollect extends BaseLogCollect {
	private final Logger log = LoggerFactory.getLogger(KafkaTraceCollect.class);

	int count = 0 ; 
	
	private final KafkaConsumer<String, String> kafkaConsumer;

	public KafkaTraceCollect(KafkaConsumer<String , String> kafkaConsumer, ApplicationEventPublisher applicationEventPublisher) {

		this.kafkaConsumer = kafkaConsumer;
		log.debug("kafkaConsumer = {}", kafkaConsumer);

		// 监听的topic
		this.kafkaConsumer.subscribe(Arrays.asList(
				MessageConstant.LOG_KEY_LOGGER
		));
		
		super.applicationEventPublisher = applicationEventPublisher;
		log.info("kafkaConsumer subscribe ready!");
		log.info("sending log ready!");
	}

	public void kafkaStart() {
		threadPoolExecutor.execute(this::collectRuningLog);
		log.info("KafkaLogCollect is starting!");
	}

	public void collectRuningLog() {
		while (true) {
			List<String> logList = new ArrayList<String>();

			log.debug("collect running log!!");

			try {
				ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));

				records.forEach(record -> {

					log.debug("topic = {}" , record.topic());
					log.debug("message = {}" , record.value());

					if (record.topic().equals(MessageConstant.LOG_KEY_LOGGER)) {

						String logString = record.value();
						// RunLogMessage runLogMessage = JSON.parseObject(logString, RunLogMessage.class);

						logList.add(logString);
					}
				});
			} catch (Exception e) {
				log.error("get logs from kafka failed! ", e);
			}

		}
	}

}