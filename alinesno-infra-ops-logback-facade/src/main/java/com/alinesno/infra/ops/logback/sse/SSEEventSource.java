package com.alinesno.infra.ops.logback.sse;

import jakarta.servlet.AsyncContext;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * SSEEventSource 类实现了 EventSource 接口，用于处理SSE（Server-Sent Events）事件源。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class SSEEventSource implements EventSource {

    private final AsyncContext asyncContext;
    private final PrintWriter out;

    /**
     * SSEEventSource 构造方法。
     *
     * @param asyncContext 异步上下文
     * @param out 输出流
     */
    public SSEEventSource(AsyncContext asyncContext, PrintWriter out) {
        this.asyncContext = asyncContext;
        this.out = out;
    }

    /**
     * 发起SSE请求的方法。
     * SSEEventSource 不需要实现此方法。
     */
    @Override
    public void request() {
        // SSEEventSource 不需要实现此方法
    }

    /**
     * 取消SSE连接的方法。
     * 关闭输出流并完成异步上下文。
     */
    @Override
    public void cancel() {
        out.close();
        asyncContext.complete();
    }
}
