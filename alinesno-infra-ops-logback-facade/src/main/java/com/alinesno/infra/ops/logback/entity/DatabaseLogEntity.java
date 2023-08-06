package com.alinesno.infra.ops.logback.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;

import java.sql.Timestamp;

/**
 * 数据库操作日志实体类
 * 用于记录MyBatis-Plus操作的数据库日志
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("database_log") // 指定数据库表名
public class DatabaseLogEntity extends InfraBaseEntity {

    // 时间戳
    @TableField("timestamp")
    private Timestamp timestamp;

    // 日志级别
    @TableField("log_level")
    private String logLevel;

    // 操作类型
    @TableField("operation_type")
    private String operationType;

    // 操作对象
    @TableField("operation_object")
    private String operationObject;

    // SQL语句
    @TableField("sql_statement")
    private String sqlStatement;

    // 参数
    @TableField("parameters")
    private String parameters;

    // 返回结果
    @TableField("result")
    private String result;

    // 执行时间
    @TableField("execution_time")
    private long executionTime;

    // 异常信息
    @TableField("exception")
    private String exception;

    // 用户名
    @TableField("username")
    private String username;

    // IP地址
    @TableField("ip_address")
    private String ipAddress;

    // 数据库名
    @TableField("database_name")
    private String databaseName;

    // 表名
    @TableField("table_name")
    private String tableName;

    // 主键值
    @TableField("primary_key_value")
    private String primaryKeyValue;

    // 日志来源应用程序
    @TableField("source_application")
    private String sourceApplication;

    // Getters and Setters
}
