package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.app.DatabaseLogEntity;
import com.alinesno.infra.ops.logback.mapper.DatabaseLogMapper;
import com.alinesno.infra.ops.logback.service.app.IDatabaseLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 数据库操作日志Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class DatabaseLogServiceImpl extends IBaseServiceImpl<DatabaseLogEntity, DatabaseLogMapper> implements IDatabaseLogService {
    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(DatabaseLogServiceImpl.class);
}
