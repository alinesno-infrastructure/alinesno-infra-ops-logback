package com.alinesno.infra.ops.logback.adapter.event;


import com.alinesno.infra.ops.logback.adapter.collect.BaseLogCollect;
import com.alinesno.infra.ops.logback.core.dto.RunLogMessage;
import org.apache.kafka.clients.consumer.internals.events.ApplicationEvent;

import java.util.List;

public class MonitorEvent extends ApplicationEvent {
    /**
     * 日志信息列表
     */
    List<RunLogMessage> logs;

    public MonitorEvent(List<RunLogMessage> logs) {
        super();
        this.logs = logs;
    }

    public List<RunLogMessage> getLogs() {
        return logs;
    }

    @Override
    public boolean process() {
        return false;
    }
}