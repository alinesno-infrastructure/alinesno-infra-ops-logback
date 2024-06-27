package com.alinesno.infra.ops.logback.service.impl.app;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.app.BusinessLogEntity;
import com.alinesno.infra.ops.logback.mapper.BusinessLogMapper;
import com.alinesno.infra.ops.logback.service.app.IBusinessLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 通用业务日志记录Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class BusinessLogServiceImpl extends IBaseServiceImpl<BusinessLogEntity, BusinessLogMapper> implements IBusinessLogService {
    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(BusinessLogServiceImpl.class);
}
