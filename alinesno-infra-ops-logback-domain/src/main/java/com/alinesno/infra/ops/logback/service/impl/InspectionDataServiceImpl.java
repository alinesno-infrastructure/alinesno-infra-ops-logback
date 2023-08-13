package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.InspectionDataEntity;
import com.alinesno.infra.ops.logback.mapper.InspectionDataMapper;
import com.alinesno.infra.ops.logback.service.IInspectionDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 巡检记录日志Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class InspectionDataServiceImpl extends IBaseServiceImpl<InspectionDataEntity, InspectionDataMapper> implements IInspectionDataService {
    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(InspectionDataServiceImpl.class);
}
