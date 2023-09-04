package com.alinesno.infra.ops.logback.sse;

/**
 * EventSourceListener 类是事件源监听器的抽象基类。
 * 用于定义事件源监听器的基本行为。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public abstract class EventSourceListener {

    /**
     * 当事件源被远程对等方接受并可以开始传输事件时调用。
     *
     * @param eventSource 事件源对象
     */
    public void onOpen(EventSource eventSource) {
    }

    /**
     * TODO 描述.
     *
     * @param eventSource 事件源对象
     * @param id 事件的标识符
     * @param type 事件的类型
     * @param data 事件的数据
     */
    public void onEvent(EventSource eventSource, String id, String type, String data) {
    }

    /**
     * TODO 描述.
     *
     * 不会再调用此监听器。
     *
     * @param eventSource 事件源对象
     */
    public void onClosed(EventSource eventSource) {
    }

    /**
     * 当由于从网络读取或写入错误而关闭事件源时调用。
     * 可能会丢失传入的事件。
     * 不会再调用此监听器。
     *
     * @param eventSource 事件源对象
     * @param t 异常对象
     */
    public void onFailure(EventSource eventSource, Throwable t) {
    }
}
