package com.alinesno.infra.ops.logback.service.impl.page;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.page.PerformanceEntity;
import com.alinesno.infra.ops.logback.mapper.PerformanceMapper;
import com.alinesno.infra.ops.logback.service.page.IPerformanceService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 性能信息Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Slf4j
@Service
public class PerformanceServiceImpl extends IBaseServiceImpl<PerformanceEntity, PerformanceMapper> implements IPerformanceService {

}
