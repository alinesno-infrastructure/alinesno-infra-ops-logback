package com.alinesno.infra.ops.logback.adapter.collect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.ops.logback.adapter.event.MonitorEvent;
import com.alinesno.infra.ops.logback.core.dto.RunLogMessage;
import com.alinesno.infra.ops.logback.core.utils.ThreadPoolUtil;
import com.alinesno.infra.ops.logback.entity.LogEntryEntity;
import com.alinesno.infra.ops.logback.service.ILogEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 采集日志基础类
 * @author luoxiaodong
 * @version 1.0.0
 */
public class BaseLogCollect {

	private final Logger log = LoggerFactory.getLogger(BaseLogCollect.class);

	public ThreadPoolExecutor threadPoolExecutor = ThreadPoolUtil.getPool();

	@Autowired
	protected ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private ILogEntryService logEntryService ;

	/**
	 * 异常日志信息监控
	 * @param logs
	 */
	protected void publisherMonitorEvent(List<String> logs) {
	 try {
		  List<RunLogMessage> errorLogs = new ArrayList<>();

		  for (String logString : logs) {
			  RunLogMessage runLogMessage = JSON.parseObject(logString, RunLogMessage.class);

			  if ("ERROR".equalsIgnoreCase(runLogMessage.getLogLevel())) {
				   errorLogs.add(runLogMessage);
			  }
		  }
		  applicationEventPublisher.publishEvent(new MonitorEvent(errorLogs));
	 } catch (Exception e) {
		  log.error("publisherMonitorEvent error!", e);
	 }
	}

	protected void handleLog(List<String> logList) {

		long startTime = System.currentTimeMillis();

		List<LogEntryEntity> batchE = new ArrayList<>() ;

		for (String logString : logList) {
			RunLogMessage l = JSON.parseObject(logString, RunLogMessage.class);

			LogEntryEntity e = new LogEntryEntity() ;

			e.setLogLevel(l.getLogLevel());
			e.setTimestamp(l.getTimeStamp());
			e.setApplicationName(l.getAppName());
			e.setThreadName(l.getThreadName());
			e.setLogMessage(l.getContent());
			if(e.getLogLevel().equalsIgnoreCase("ERROR")){
				e.setException(l.getContent());
			}
			e.setIpAddress(l.getServerName());
			e.setRequestMethod(l.getMethod());
			e.setResponseTime(l.getSeq());
			e.setLogId(l.getTraceId());

			e.setLogDuration(l.getNanoseconds());
			e.setLogExtraData(JSONObject.toJSONString(l.getMDCPropertyMap()));
			e.setLogEnvironment(l.getEnv());

			e.setJvm(JSONObject.parseObject(JSONObject.toJSONString(l.getJvm())));
			e.setMem(JSONObject.parseObject(JSONObject.toJSONString(l.getMem())));

			// TODO
//			e.setResponseCode();
//			e.setRequestParameters();
//			e.setUsername();
//			e.setRequestUrl();

			batchE.add(e) ;
		}

		logEntryService.batchInsertLogEntries(batchE) ;

		long endTime = System.currentTimeMillis();

		long elapsedTime = endTime - startTime;
		System.out.println("方法执行时间：" + elapsedTime + " 毫秒 , 插入数据:"+ batchE.size() +" 条");
	}
}