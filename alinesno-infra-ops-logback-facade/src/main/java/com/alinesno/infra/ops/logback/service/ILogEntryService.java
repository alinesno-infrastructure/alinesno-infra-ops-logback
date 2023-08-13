package com.alinesno.infra.ops.logback.service;

import com.alinesno.infra.common.facade.services.IBaseService;
import com.alinesno.infra.ops.logback.entity.LogEntryEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * 日志记录Service接口
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
public interface ILogEntryService extends IBaseService<LogEntryEntity> {

    /**
     * 批量保存日志信息，使用jdbc而不是使用mybatis
     * @param batchE
     */
    void batchInsertLogEntries(List<LogEntryEntity> batchE) ;

}
