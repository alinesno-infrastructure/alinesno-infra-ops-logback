package com.alinesno.infra.ops.logback.core.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.alinesno.infra.ops.logback.core.MessageAppenderFactory;
import com.alinesno.infra.ops.logback.core.dto.BaseLogMessage;
import com.alinesno.infra.ops.logback.core.utils.LogMessageUtil;
import com.alinesno.infra.ops.logback.core.utils.ThreadPoolUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 通过Http发送请求日志到指定的日志服务器
 *
 * @author chenlongfei
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RestAppender extends AppenderBase<ILoggingEvent> {

    private static final ThreadPoolExecutor threadPoolExecutor = ThreadPoolUtil.getPool();
    private String appName;
    private String env = "default";
    private String userKey; // 应用密钥
    private String runModel;
    private String expand;
    private String restHost;
    private int maxCount = 100;
    private int logQueueSize = 10000;
    private int threadPoolSize = 1;
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
            System.err.println("未配置【userKey】密钥，无法写入日志审计服务!");
            return ;
        }

        // 配置应用日志密钥
        logMessage.setUserKey(userKey);

        try{
            String message = LogMessageUtil.getLogMessage(logMessage, event);
            MessageAppenderFactory.pushRundataQueue(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        super.start();
        MessageAppenderFactory.initQueue(this.logQueueSize);

        for (int a = 0; a < this.threadPoolSize; a++) {
            threadPoolExecutor.execute(() ->
                    MessageAppenderFactory.startRunLog(
                    this.restHost,
                    this.maxCount,
                    this.compressor ? "lz4" : "none",
                    this.compressor)
            );
        }
    }
}
