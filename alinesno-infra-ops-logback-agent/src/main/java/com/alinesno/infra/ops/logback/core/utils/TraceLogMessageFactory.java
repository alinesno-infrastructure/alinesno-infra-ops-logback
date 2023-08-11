package com.alinesno.infra.ops.logback.core.utils;

import com.alinesno.infra.ops.logback.core.dto.RunLogMessage;

/**
 * TraceLogMessageFactory类是一个跟踪日志消息工厂，提供了创建和处理跟踪日志消息的方法。
 *
 * className：TraceLogMessageFactory
 * time：2020-05-13.14:04
 *
 * @version 1.0.0
 * @author Tank
 * @author luoxiaodong
 */
public class TraceLogMessageFactory<T> {

    /**
     * 根据给定的参数创建一个运行日志消息对象。
     *
     * @param appName 应用程序名称
     * @param env 环境
     * @param message 消息内容
     * @param time 时间戳
     * @return 创建的运行日志消息对象
     */
    public static RunLogMessage getLogMessage(String appName, String env, String message, long time) {
        RunLogMessage logMessage = new RunLogMessage();

        logMessage.setServerName(IpGetter.CURRENT_IP);
        logMessage.setAppName(appName);
        logMessage.setEnv(env);
        logMessage.setContent(message);
        logMessage.setDtTime(time);

        return logMessage;
    }

    /**
     * 将消息和参数打包成一个完整的消息字符串。
     *
     * @param message 消息内容
     * @param args 参数数组
     * @return 打包后的完整消息字符串
     */
    public static String packageMessage(String message, Object[] args) {
        StringBuilder builder = new StringBuilder(128);
        builder.append(message);
        for (Object arg : args) {
            builder.append("\n").append(arg);
        }
        return builder.toString();
    }

}
