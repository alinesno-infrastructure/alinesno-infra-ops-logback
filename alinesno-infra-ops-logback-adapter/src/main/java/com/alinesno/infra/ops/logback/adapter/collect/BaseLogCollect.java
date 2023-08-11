package com.alinesno.infra.ops.logback.adapter.collect;

import com.alinesno.infra.ops.logback.adapter.event.MonitorEvent;
import com.alinesno.infra.ops.logback.core.utils.ThreadPoolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 采集日志基础类
 * @author luoxiaodong
 * @version 1.0.0
 */
public class BaseLogCollect {

	private final Logger log = LoggerFactory.getLogger(BaseLogCollect.class);

	public ThreadPoolExecutor threadPoolExecutor = ThreadPoolUtil.getPool();

	protected ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
	protected ApplicationEventPublisher applicationEventPublisher;

	protected void publisherMonitorEvent(List<String> logs) {
		int size = logs.size();
		if (size > 0) {
			try {
				logs = null;
				applicationEventPublisher.publishEvent(new MonitorEvent(this, logs));
			} catch (Exception e) {
				log.error("publisherMonitorEvent error!", e);
			}
		}

	}

}