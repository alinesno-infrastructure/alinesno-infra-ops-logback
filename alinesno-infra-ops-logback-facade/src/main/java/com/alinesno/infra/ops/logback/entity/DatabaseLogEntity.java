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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationObject() {
        return operationObject;
    }

    public void setOperationObject(String operationObject) {
        this.operationObject = operationObject;
    }

    public String getSqlStatement() {
        return sqlStatement;
    }

    public void setSqlStatement(String sqlStatement) {
        this.sqlStatement = sqlStatement;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPrimaryKeyValue() {
        return primaryKeyValue;
    }

    public void setPrimaryKeyValue(String primaryKeyValue) {
        this.primaryKeyValue = primaryKeyValue;
    }

    public String getSourceApplication() {
        return sourceApplication;
    }

    public void setSourceApplication(String sourceApplication) {
        this.sourceApplication = sourceApplication;
    }
}
