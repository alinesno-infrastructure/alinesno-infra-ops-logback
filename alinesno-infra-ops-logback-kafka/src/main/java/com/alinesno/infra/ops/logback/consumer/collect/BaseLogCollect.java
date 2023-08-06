package com.alinesno.infra.ops.logback.consumer.collect;

import com.alibaba.fastjson.JSON;
import com.alinesno.infra.ops.logback.consumer.cache.AppNameCache;
import com.alinesno.infra.ops.logback.consumer.monitor.MonitorEvent;
import com.alinesno.infra.ops.logback.core.dto.RunLogMessage;
import com.alinesno.infra.ops.logback.core.utils.ThreadPoolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;

import java.util.ArrayList;
import java.util.HashSet;
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
				List<RunLogMessage> errorLogs = new ArrayList<>();

				for (String logString : logs) {
					RunLogMessage runLogMessage = JSON.parseObject(logString, RunLogMessage.class);

					AppNameCache.appName.computeIfAbsent(runLogMessage.getAppName(), k -> new HashSet<>()) .add(runLogMessage.getEnv());
					if ("ERROR".equalsIgnoreCase(runLogMessage.getLogLevel())) {
						errorLogs.add(runLogMessage);
					}
				}

				logs = null;
				applicationEventPublisher.publishEvent(new MonitorEvent(this, errorLogs));
			} catch (Exception e) {
				log.error("publisherMonitorEvent error!", e);
			}
		}

	}

	/**
	 * 保存日志服务
	 * @param sendList
	 */
	public void sendLog(List<String> sendList) {
		try {
			if (!sendList.isEmpty()) {
//				elasticLowerClient.insertListLog(sendList, index, LogMessageConstant.ES_TYPE);
			}
		} catch (Exception e) {
			log.error("logList insert es failed!", e);
		}
	}

}
