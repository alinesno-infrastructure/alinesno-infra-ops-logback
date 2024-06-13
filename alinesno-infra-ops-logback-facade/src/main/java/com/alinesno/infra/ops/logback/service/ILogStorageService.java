package com.alinesno.infra.ops.logback.service;

import com.alinesno.infra.common.facade.services.IBaseService;
import com.alinesno.infra.ops.logback.entity.LogStorageEntity;

import java.util.List;

/**
 * 日志记录Service接口
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
public interface ILogStorageService extends IBaseService<LogStorageEntity> {

    /**
     * 批量保存日志信息，使用jdbc而不是使用mybatis
     * @param batchE
     */
    void batchInsertLogEntries(List<LogStorageEntity> batchE) ;

}
