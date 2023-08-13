package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.LogEntryEntity;
import com.alinesno.infra.ops.logback.mapper.LogEntryMapper;
import com.alinesno.infra.ops.logback.service.ILogEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 日志记录Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class LogEntryServiceImpl extends IBaseServiceImpl<LogEntryEntity, LogEntryMapper> implements ILogEntryService {
    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(LogEntryServiceImpl.class);
}
