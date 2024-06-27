package com.alinesno.infra.ops.logback.adapter.collect;

import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Kafka日志采集，保存到postgresql当中
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@ConditionalOnBean(name = "kafkaConsumer")
@Component
public class KafkaCollect extends BaseLogCollect {

	@Autowired
	private KafkaConsumer<String , String> kafkaConsumer;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public void kafkaStart() {
		log.debug("kafkaConsumer = {}", kafkaConsumer);

		// 监听的topic
		kafkaConsumer.subscribe(List.of(
                MessageConstant.LOG_KEY_LOGGER
        ));

		log.info("kafkaConsumer subscribe ready!");
		log.info("sending log ready!");

		threadPoolExecutor.execute(this::collectRuningLog);
		log.info("KafkaLogCollect is starting!");
	}

	public void collectRuningLog() {
		while (true) {
			List<String> logList = new ArrayList<>();

			log.debug("kafka collect running log!!");

			try {
				ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));

				records.forEach(record -> {
					log.debug("topic = {}" , record.topic());
					log.debug("message = {}" , record.value());

					if (record.topic().equals(MessageConstant.LOG_KEY_LOGGER)) {

						String logString = record.value() ;

						// RunLogMessage runLogMessage = JSON.parseObject(logString, RunLogMessage.class);

						logList.add(logString);
					}
				});
			} catch (Exception e) {
				log.error("get logs from kafka failed! ", e);
			}

			// 业务日志
			if (!logList.isEmpty()) {
				super.handleLog(logList) ;
				publisherMonitorEvent(logList);
			}

		}
	}

}