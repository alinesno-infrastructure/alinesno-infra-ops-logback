package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.ProjectEntity;
import com.alinesno.infra.ops.logback.mapper.ProjectMapper;
import com.alinesno.infra.ops.logback.service.IProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 应用构建Service业务层处理
 * 
 * @version 1.0.0
 * @since 2023-09-30
 */
@Slf4j
@Service
public class ApplicationServiceImpl extends IBaseServiceImpl<ProjectEntity, ProjectMapper> implements IProjectService {

}