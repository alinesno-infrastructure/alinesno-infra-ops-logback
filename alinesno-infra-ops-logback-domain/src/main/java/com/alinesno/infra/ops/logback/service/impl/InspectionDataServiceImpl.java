package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.app.InspectionLogEntity;
import com.alinesno.infra.ops.logback.mapper.InspectionLogMapper;
import com.alinesno.infra.ops.logback.service.app.IInspectionLogService;
import org.springframework.stereotype.Service;

/**
 * 巡检记录日志Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class InspectionDataServiceImpl extends IBaseServiceImpl<InspectionLogEntity, InspectionLogMapper> implements IInspectionLogService {
}
