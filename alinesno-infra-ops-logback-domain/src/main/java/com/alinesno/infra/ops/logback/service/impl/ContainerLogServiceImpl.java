package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.channel.ContainerLogEntity;
import com.alinesno.infra.ops.logback.mapper.ContainerLogMapper;
import com.alinesno.infra.ops.logback.service.channel.IContainerLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContainerLogServiceImpl extends IBaseServiceImpl<ContainerLogEntity, ContainerLogMapper> implements IContainerLogService {
}
