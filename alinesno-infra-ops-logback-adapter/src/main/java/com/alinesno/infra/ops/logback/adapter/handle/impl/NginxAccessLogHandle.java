package com.alinesno.infra.ops.logback.adapter.handle.impl;

import com.alinesno.infra.ops.logback.adapter.handle.BaseHandle;
import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 处理Nginx日志
 */
@Slf4j
@Component(MessageConstant.REDIS_REST_NGINX_ACCESS_KEY)
public class NginxAccessLogHandle implements BaseHandle {
    @Override
    public void analyseMessage(String message) {
        log.debug("-->> NginxAccessLogHandle message = {}" , message);
    }
}
