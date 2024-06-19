package com.alinesno.infra.ops.logback.adapter.handle.impl;

import com.alinesno.infra.ops.logback.adapter.handle.BaseHandle;
import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 处理应用数据库操作日志
 */
@Slf4j
@Component(MessageConstant.REDIS_REST_DATABASE_KEY)
public class DatabaseLogHandle implements BaseHandle {
    @Override
    public void analyseMessage(String message) {
        log.debug("-->> DatabaseLogHandle message = {}" , message);
    }
}
