package com.alinesno.infra.ops.logback.service.impl.app;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.app.DatabaseSqlStatEntity;
import com.alinesno.infra.ops.logback.mapper.DatabaseSqlStatMapper;
import com.alinesno.infra.ops.logback.service.app.IDatabaseSqlStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 通用业务日志记录Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Slf4j
@Service
public class BusinessSqlStatServiceImpl extends IBaseServiceImpl<DatabaseSqlStatEntity, DatabaseSqlStatMapper> implements IDatabaseSqlStatService {

}
