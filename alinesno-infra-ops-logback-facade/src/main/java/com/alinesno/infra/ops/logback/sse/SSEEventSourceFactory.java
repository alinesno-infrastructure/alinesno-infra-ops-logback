package com.alinesno.infra.ops.logback.sse;

import jakarta.servlet.AsyncContext;

import java.io.PrintWriter;

/**
 * SSEEventSourceFactory 类实现了 EventSource.Factory 接口，用于创建 SSEEventSource 实例。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class SSEEventSourceFactory implements EventSource.Factory {

    private final AsyncContext asyncContext;

    /**
     * SSEEventSourceFactory 构造方法。
     *
     * @param asyncContext 异步上下文
     */
    public SSEEventSourceFactory(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    /**
     * 创建 EventSource 实例的方法。
     *
     * @param listener 事件源监听器
     * @return 创建的 EventSource 实例
     */
    @Override
    public EventSource newEventSource(EventSourceListener listener) {
        PrintWriter out = null;
        try {
            out = asyncContext.getResponse().getWriter();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SSEEventSource(asyncContext, out);
    }
}
