package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.PerformanceInfoEntity;
import com.alinesno.infra.ops.logback.mapper.PerformanceInfoMapper;
import com.alinesno.infra.ops.logback.service.IPerformanceInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 性能信息Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class PerformanceInfoServiceImpl extends IBaseServiceImpl<PerformanceInfoEntity, PerformanceInfoMapper> implements IPerformanceInfoService {
    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(PerformanceInfoServiceImpl.class);
}
