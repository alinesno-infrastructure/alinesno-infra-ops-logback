package com.alinesno.infra.ops.logback.core.utils;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.ThrowableProxy;
import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import com.alinesno.infra.ops.logback.core.context.SystemInfoFetcher;
import com.alinesno.infra.ops.logback.core.dto.*;
import org.slf4j.helpers.MessageFormatter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class LogMessageUtil {

    private static final AtomicLong SEQ_BUILDER = new AtomicLong();

    /**
     * 扩展字段
     *
     * @param baseLogMessage
     * @param iLoggingEvent
     * @return
     */
    public static String getLogMessage(BaseLogMessage baseLogMessage, final ILoggingEvent iLoggingEvent) {
        Map<String, Object> map = StringUtils.entityToMap(baseLogMessage);
        return GfJsonUtil.toJSONString(map);
    }

    public static BaseLogMessage getLogMessage(final String appName, final String env, final ILoggingEvent iLoggingEvent) {

        String formattedMessage = getMessage(iLoggingEvent);
        RunLogMessage logMessage =  LogMessageFactory.getLogMessage(appName, env, formattedMessage, iLoggingEvent.getTimeStamp());

        logMessage.setClassName(iLoggingEvent.getLoggerName());
        logMessage.setThreadName(iLoggingEvent.getThreadName());
        logMessage.setSeq(SEQ_BUILDER.getAndIncrement());

        logMessage.setMDCPropertyMap(iLoggingEvent.getMDCPropertyMap()); ;
        logMessage.setTimeStamp(iLoggingEvent.getTimeStamp());
        logMessage.setNanoseconds(iLoggingEvent.getNanoseconds());

        // running time
        // TODO 待优化消息内容和大小问题，还有开关的问题

        long startTime = System.currentTimeMillis();

//        JVMDto jvm = SystemInfoFetcher.getJVMInfo() ;
//        MemDto mem = SystemInfoFetcher.getMemoryDetails() ;
//        logMessage.setJvm(jvm);
//        logMessage.setMem(mem);

        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
//        System.out.print("===>>> 方法执行时间：" + elapsedTime + " 毫秒");

        StackTraceElement[] stackTraceElements = iLoggingEvent.getCallerData();

        if(stackTraceElements.length>0) {
            StackTraceElement stackTraceElement=stackTraceElements[0];
            String method = stackTraceElement.getMethodName();
            String line = String.valueOf(stackTraceElement.getLineNumber());
            logMessage.setMethod(method + "(" + stackTraceElement.getFileName() + ":" + line + ")");
        } else {
            logMessage.setMethod(iLoggingEvent.getThreadName());
        }

        // dateTime字段用来保存当前服务器的时间戳字符串
        logMessage.setDateTime(DateUtil.getDatetimeNormalStrWithMills(iLoggingEvent.getTimeStamp()));
        logMessage.setLogLevel(iLoggingEvent.getLevel().toString());

        return logMessage;
    }

    private static String getMessage(ILoggingEvent logEvent) {

        if (logEvent.getLevel().equals(Level.ERROR)) {
            if (logEvent.getThrowableProxy() != null) {
                ThrowableProxy throwableProxy = (ThrowableProxy) logEvent.getThrowableProxy();
                String[] args = new String[]{logEvent.getFormattedMessage() + "\n" + LogExceptionStackTrace.erroStackTrace(throwableProxy.getThrowable()).toString()};
                return packageMessage("{}", args);
            } else {
                Object[] args = logEvent.getArgumentArray();
                if (args != null) {
                    for (int i = 0; i < args.length; i++) {
                        if (args[i] instanceof Throwable) {
                            args[i] = LogExceptionStackTrace.erroStackTrace(args[i]);
                        }
                    }
                    return packageMessage(logEvent.getMessage(), args);
                }
            }
        }
        return logEvent.getFormattedMessage();
    }

    private static String packageMessage(String message, Object[] args) {
        if (message != null && message.contains(MessageConstant.DELIM_STR)) {
            return MessageFormatter.arrayFormat(message, args).getMessage();
        }
        return LogMessageFactory.packageMessage(message, args);
    }
}
