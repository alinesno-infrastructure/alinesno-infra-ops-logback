package com.alinesno.infra.ops.logback.service;

import com.alinesno.infra.common.facade.services.IBaseService;
import com.alinesno.infra.ops.logback.entity.ProjectAccountEntity;
import com.alinesno.infra.ops.logback.entity.ProjectEntity;

import java.util.List;

/**
 * 应用构建Service接口
 * 
 * @version 1.0.0
 * @since 2023-09-30
 */
public interface IProjectAccountService extends IBaseService<ProjectAccountEntity> {

    /**
     * 获取用户当前应用
     * @param userId
     * @return
     */
    ProjectEntity getApplicationByAccountId(long userId);

    /**
     * 初始化用户应用服务
     * @param userId
     */
    void initDefaultProject(long userId);

}