package com.alinesno.infra.ops.logback.sse;

import com.alinesno.infra.ops.logback.sse.EventSourceListener;
import com.alinesno.infra.ops.logback.sse.IStreamLoggerClient;
import org.springframework.stereotype.Service;

/**
 * StreamLoggerClientImpl 类实现了 IStreamLoggerClient 接口，用于模拟不断输出日志的功能。
 */
@Service
public class StreamLoggerClientImpl implements IStreamLoggerClient {

    /**
     * 模拟不断输出日志的方法。
     *
     * @param eventSourceListener 事件源监听器
     */
    @Override
    public void streamChatCompletion(EventSourceListener eventSourceListener) {
        // 模拟不断输出日志的线程
        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    // 模拟生成日志数据
                    String logData = "Log entry " + i;
                    // 发送日志数据给事件源监听器
                    eventSourceListener.onEvent(null, null, null, logData);
                    // 模拟等待一段时间
                    Thread.sleep(100);
                }
                // 发送完所有日志数据后关闭事件源
                eventSourceListener.onClosed(null);
            } catch (InterruptedException e) {
                String errorMessage = "SSE output interrupted: " + e.getMessage();
                eventSourceListener.onEvent(null, null, "error", errorMessage);
                eventSourceListener.onClosed(null);
            }
        }).start();
    }
}
