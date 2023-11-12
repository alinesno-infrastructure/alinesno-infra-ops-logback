package com.alinesno.infra.ops.logback.mapper;

import com.alinesno.infra.common.facade.mapper.repository.IBaseMapper;
import com.alinesno.infra.ops.logback.entity.ApplicationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 应用构建Mapper接口
 * 
 * @version 1.0.0
 * @since 2023-09-30
 */
@Mapper
public interface ApplicationMapper extends IBaseMapper<ApplicationEntity> {

}