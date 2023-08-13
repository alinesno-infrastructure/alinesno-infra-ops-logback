package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.LogTypeEntity;
import com.alinesno.infra.ops.logback.mapper.LogTypeMapper;
import com.alinesno.infra.ops.logback.service.ILogTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 日志类型管理Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class LogTypeServiceImpl extends IBaseServiceImpl<LogTypeEntity, LogTypeMapper> implements ILogTypeService {
    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(LogTypeServiceImpl.class);
}
