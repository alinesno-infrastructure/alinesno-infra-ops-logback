package com.alinesno.infra.ops.logback.enums;

public enum LogbackStatus {
    SENT("已发送"),
    PENDING("待发送"),
    SENDING("发送中"),
    FAILED("发送失败");

    private String status;

    LogbackStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
