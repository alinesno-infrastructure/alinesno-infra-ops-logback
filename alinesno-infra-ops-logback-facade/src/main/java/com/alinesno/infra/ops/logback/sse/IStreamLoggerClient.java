package com.alinesno.infra.ops.logback.sse;

/**
 * IStreamLoggerClient 接口定义了日志服务的方法。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface IStreamLoggerClient {

    /**
     * 模拟不断输出日志的方法。
     *
     * @param eventSourceListener 事件源监听器
     */
    void streamChatCompletion(EventSourceListener eventSourceListener);
}
