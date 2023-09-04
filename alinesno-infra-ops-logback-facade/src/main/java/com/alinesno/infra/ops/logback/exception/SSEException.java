package com.alinesno.infra.ops.logback.exception;

public class SSEException extends Exception {
    private String customMessage;

    public SSEException(String customMessage) {
        this.customMessage = customMessage;
    }

    @Override
    public String toString() {
        return customMessage;
    }
}
