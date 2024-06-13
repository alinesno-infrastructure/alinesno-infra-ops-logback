package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.channel.NginxAccessLogEntity;
import com.alinesno.infra.ops.logback.mapper.NginxAccessLogMapper;
import com.alinesno.infra.ops.logback.service.channel.INginxAccessLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Nginx访问日志Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class NginxAccessLogServiceImpl extends IBaseServiceImpl<NginxAccessLogEntity, NginxAccessLogMapper> implements INginxAccessLogService {
    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(NginxAccessLogServiceImpl.class);
}
