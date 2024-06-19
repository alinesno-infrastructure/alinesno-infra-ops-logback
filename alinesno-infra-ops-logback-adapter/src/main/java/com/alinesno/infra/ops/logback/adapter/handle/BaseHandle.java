package com.alinesno.infra.ops.logback.adapter.handle;

public interface BaseHandle {

    /**
     * 处理业务日志
     * @param message
     */
    void analyseMessage(String message)  ;

}
