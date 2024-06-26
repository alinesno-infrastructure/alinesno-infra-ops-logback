package com.alinesno.infra.ops.logback.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.LogStorageEntity;
import com.alinesno.infra.ops.logback.mapper.LogStorageMapper;
import com.alinesno.infra.ops.logback.service.ILogStorageService;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * 日志记录Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Slf4j
@Service
public class LogStorageServiceImpl extends IBaseServiceImpl<LogStorageEntity, LogStorageMapper> implements ILogStorageService {

//    @Autowired
//    private SqlSessionTemplate sqlSessionTemplate;

    @Resource(name="primaryDataSource")
    private DruidDataSource druidDataSource ;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public void batchInsertLogEntries(List<LogStorageEntity> batchE) {

        Connection connection = null;
        try {
//            connection = sqlSessionTemplate.getConnection();
            connection = druidDataSource.getConnection() ;

            // 关闭自动提交
            connection.setAutoCommit(false);

            // 创建 PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " +
                    "log_storage " +
                    "   (id, timestamp, log_level, thread_name, log_message, exception, ip_address, request_method, response_code, response_time, log_extra_data, log_duration, log_environment, has_delete, application_name, tenant_id, add_time, has_status) " +
                    "   VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // 批量插入数据
            for (LogStorageEntity data : batchE) {

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
                preparedStatement.setDate(17, new Date(System.currentTimeMillis()));
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
