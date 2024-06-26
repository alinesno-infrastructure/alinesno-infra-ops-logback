package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.enums.HasStatusEnums;
import com.alinesno.infra.ops.logback.entity.ProjectAccountEntity;
import com.alinesno.infra.ops.logback.entity.ProjectEntity;
import com.alinesno.infra.ops.logback.enums.ProviderChannelEnum;
import com.alinesno.infra.ops.logback.mapper.ProjectAccountMapper;
import com.alinesno.infra.ops.logback.service.IProjectAccountService;
import com.alinesno.infra.ops.logback.service.IProjectService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqids.Sqids;

import java.util.Arrays;
import java.util.List;

/**
 * 应用构建Service业务层处理
 * 
 * @version 1.0.0
 * @since 2023-09-30
 */
@Slf4j
@Service
public class ProjectAccountServiceImpl extends IBaseServiceImpl<ProjectAccountEntity, ProjectAccountMapper> implements IProjectAccountService {

    @Autowired
    private IProjectService applicationService ;

    @Override
    public ProjectEntity getApplicationByAccountId(long userId) {

        LambdaQueryWrapper<ProjectAccountEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>() ;

        lambdaQueryWrapper.eq(ProjectAccountEntity::getAccountId , userId)
                .orderByDesc(ProjectAccountEntity::getAppOrder) ;

        List<ProjectAccountEntity> es = list(lambdaQueryWrapper) ;

        return CollectionUtils.isEmpty(es) ? null : applicationService.getById(es.get(0).getApplicationId());
    }

    @Override
    public void initDefaultProject(long userId) {

    }

}