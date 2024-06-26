package com.alinesno.infra.ops.logback.core.logback;


import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.alinesno.infra.ops.logback.core.MessageAppenderFactory;
import com.alinesno.infra.ops.logback.core.dto.BaseLogMessage;
import com.alinesno.infra.ops.logback.core.kafka.KafkaProducerClient;
import com.alinesno.infra.ops.logback.core.utils.LogMessageUtil;
import com.alinesno.infra.ops.logback.core.utils.ThreadPoolUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * className：KafkaAppender
 * description：KafkaAppender 如果使用kafka作为队列用这个KafkaAppender输出
 *
 * @author Frank.chen
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class KafkaAppender extends AppenderBase<ILoggingEvent> {

    private static final ThreadPoolExecutor threadPoolExecutor  = ThreadPoolUtil.getPool();

    private KafkaProducerClient kafkaClient;
    private String appName;
    private String env = "default";
    private String kafkaHosts;
    private String userKey ; // 应用密钥
    private int maxCount = 100;
    private int logQueueSize = 10000;
    private int threadPoolSize = 2;
    private boolean compressor = false;

    @Override
    protected void append(ILoggingEvent event) {
        if (event != null) {
            send(event);
        }
    }

    protected void send(ILoggingEvent event) {
        final BaseLogMessage logMessage = LogMessageUtil.getLogMessage(appName, env, event);
        
        if(userKey == null) {
        	System.err.print("未配置【userKey】密钥，无法写入日志审计服务!");
        	return ; 
        }
      
        // 配置应用日志密钥
        logMessage.setUserKey(userKey);

        String message = LogMessageUtil.getLogMessage(logMessage, event);
        MessageAppenderFactory.pushRundataQueue(message);
    }

    @Override
    public void start() {
        super.start();

        if (this.kafkaClient == null) {
            this.kafkaClient = KafkaProducerClient.getInstance(this.kafkaHosts, this.compressor ? "lz4" : "none");
        }

        MessageAppenderFactory.initQueue(this.logQueueSize);

        for (int i = 0; i < this.threadPoolSize; i++) {
            threadPoolExecutor.execute(() -> {
                MessageAppenderFactory.startRunLog(this.kafkaClient, this.maxCount);
            });
        }

    }
}
