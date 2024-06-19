package com.alinesno.infra.ops.logback.service;

import com.alinesno.infra.common.facade.services.IBaseService;
import com.alinesno.infra.ops.logback.entity.ProjectEntity;

import java.util.List;

/**
 * 应用构建Service接口
 * 
 * @version 1.0.0
 * @since 2023-09-30
 */
public interface IProjectService extends IBaseService<ProjectEntity> {

    /**
     * 获取当前应用支持的文档类型
     * @param appCode
     * @return
     */
    List<String> getDocumentType(String appCode);

    /**
     * 保存应用文档类型
     * @param documentStr
     */
    void saveDocumentType(String projectId , String documentStr) ;

    /**
     * 初始化默认应用
     * @param userId
     */
    void initDefaultApp(long userId);

    /**
     * 获取到默认应用标识
     * @return
     */
    ProjectEntity getDefaultProject(long userId);

    /**
     * 判断应用是否开启
     * @param projectCode
     * @return
     */
    boolean isOpen(String projectCode);

}