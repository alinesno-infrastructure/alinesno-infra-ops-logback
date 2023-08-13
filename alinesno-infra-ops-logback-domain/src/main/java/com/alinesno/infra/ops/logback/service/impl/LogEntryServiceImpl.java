package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.LogEntryEntity;
import com.alinesno.infra.ops.logback.mapper.LogEntryMapper;
import com.alinesno.infra.ops.logback.service.ILogEntryService;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * 日志记录Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class LogEntryServiceImpl extends IBaseServiceImpl<LogEntryEntity, LogEntryMapper> implements ILogEntryService {

    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(LogEntryServiceImpl.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public void batchInsertLogEntries(List<LogEntryEntity> batchE) {

        Connection connection = null;
        try {
            connection = sqlSessionTemplate.getConnection();

            // 关闭自动提交
            connection.setAutoCommit(false);

            // 创建 PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO a_log_record (id, timestamp, log_level, thread_name, log_message, exception, ip_address, request_method, response_code, response_time, log_extra_data, log_duration, log_environment, has_delete, application_name, tenant_id, add_time, has_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // 批量插入数据
            for (LogEntryEntity data : batchE) {

                data.setId(IdWorker.getId());

                preparedStatement.setLong(1, data.getId());
                preparedStatement.setLong(2, data.getTimestamp());
                preparedStatement.setString(3, data.getLogLevel());
                preparedStatement.setString(4, data.getThreadName());
                preparedStatement.setString(5, data.getLogMessage());
                preparedStatement.setString(6, data.getException());
                preparedStatement.setString(7, data.getIpAddress());
                preparedStatement.setString(8, data.getRequestMethod());
                preparedStatement.setInt(9, data.getResponseCode());
                preparedStatement.setLong(10, data.getResponseTime());
                preparedStatement.setString(11, data.getLogExtraData());
                preparedStatement.setLong(12, data.getLogDuration());
                preparedStatement.setString(13, data.getLogEnvironment());
                preparedStatement.setInt(14, data.getHasDelete());
                preparedStatement.setString(15, data.getApplicationName());
                preparedStatement.setString(16, data.getTenantId());
                preparedStatement.setLong(17, data.getTimestamp());
                preparedStatement.setInt(18, data.getHasStatus());

                preparedStatement.addBatch();
            }

            // 执行批处理
            int[] result = preparedStatement.executeBatch();

            // 提交事务
            connection.commit();

            // 关闭资源
            preparedStatement.close();

        } catch (SQLException e) {

            log.error("数据插入异常:{}" , e.getMessage());
            // 出现异常时回滚事务
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException ex) {
                log.error("数据插入回滚异常:{}" , e.getMessage());
            }
            throw new RuntimeException(e);
        }


    }
}
