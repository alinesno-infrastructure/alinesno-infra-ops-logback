package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.LogGroupEntity;
import com.alinesno.infra.ops.logback.mapper.LogTypeMapper;
import com.alinesno.infra.ops.logback.service.ILogGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 日志类型管理Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Slf4j
@Service
public class LogTypeServiceImpl extends IBaseServiceImpl<LogGroupEntity, LogTypeMapper> implements ILogGroupService {

}
