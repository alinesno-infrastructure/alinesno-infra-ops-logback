package com.alinesno.infra.ops.logback.adapter.handle.impl;

import com.alinesno.infra.ops.logback.adapter.handle.BaseHandle;
import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 处理业务日志消息
 */
@Slf4j
@Component(MessageConstant.REDIS_REST_BUSINESS_KEY)
public class BusinessLogHandle implements BaseHandle {

    @Override
    public void analyseMessage(String message) {
        log.debug("-->> BusinessLogHandle message = {}" , message);
    }

}
