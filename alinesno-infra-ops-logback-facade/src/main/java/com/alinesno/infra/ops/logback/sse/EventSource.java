package com.alinesno.infra.ops.logback.sse;

/**
 * EventSource 接口用于定义事件源的基本行为。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public interface EventSource {
    /**
     * 返回发起此事件源的原始请求。
     *
     * @return 原始请求对象
     */
    void request();

    /**
     * 立即释放此事件源所持有的资源。如果事件源已关闭或取消，此方法不执行任何操作。
     */
    void cancel();

    /**
     * EventSource.Factory 接口用于创建事件源对象。
     */
    interface Factory {
        /**
         * 创建一个新的事件源并立即返回。创建事件源将启动一个异步过程来连接套接字。
         * 一旦连接成功或失败，将通知 `listener`。调用者在事件源不再使用时必须取消返回的事件源。
         *
         * @param listener 事件源监听器
         * @return 事件源对象
         */
        EventSource newEventSource(EventSourceListener listener);
    }
}
