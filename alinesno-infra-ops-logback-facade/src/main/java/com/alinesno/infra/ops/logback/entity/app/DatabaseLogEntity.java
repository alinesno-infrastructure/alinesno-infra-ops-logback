package com.alinesno.infra.ops.logback.entity.app;

import com.alinesno.infra.ops.logback.entity.BaseLogEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Timestamp;

/**
 * 数据库操作日志实体类
 * 用于记录MyBatis-Plus操作的数据库日志
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("database_log") // 指定数据库表名
@Data
public class DatabaseLogEntity extends BaseLogEntity {

    // 时间戳
    @TableField("timestamp")
	@ColumnType(length=20)
	@ColumnComment("时间戳")
    private Timestamp timestamp;

    // 日志级别
    @TableField("log_level")
	@ColumnType(length=10)
	@ColumnComment("日志级别")
    private String logLevel;

    // 操作类型
    @TableField("operation_type")
	@ColumnType(length=10)
	@ColumnComment("操作类型")
    private String operationType;

    // 操作对象
    @TableField("operation_object")
	@ColumnType(length=255)
	@ColumnComment("操作对象")
    private String operationObject;

    // SQL语句
    @TableField("sql_statement")
	@ColumnType(length=255)
	@ColumnComment("SQL语句")
    private String sqlStatement;

    // 参数
    @TableField("parameters")
	@ColumnType(length=255)
	@ColumnComment("参数")
    private String parameters;

    // 返回结果
    @TableField("result")
	@ColumnType(length=255)
	@ColumnComment("返回结果")
    private String result;

    // 执行时间
    @TableField("execution_time")
	@ColumnType(length=8)
	@ColumnComment("执行时间")
    private long executionTime;

    // 异常信息
    @TableField("exception")
	@ColumnType(length=255)
	@ColumnComment("异常信息")
    private String exception;

    // 用户名
    @TableField("username")
	@ColumnType(length=255)
	@ColumnComment("用户名")
    private String username;

    // IP地址
    @TableField("ip_address")
	@ColumnType(length=15)
	@ColumnComment("IP地址")
    private String ipAddress;

    // 数据库名
    @TableField("database_name")
	@ColumnType(length=255)
	@ColumnComment("数据库名")
    private String databaseName;

    // 表名
    @TableField("table_name")
	@ColumnType(length=255)
	@ColumnComment("表名")
    private String tableName;

    // 主键值
    @TableField("primary_key_value")
	@ColumnType(length=255)
	@ColumnComment("主键值")
    private String primaryKeyValue;

    // 日志来源应用程序
    @TableField("source_application")
	@ColumnType(length=50)
	@ColumnComment("日志来源应用程序")
    private String sourceApplication;
}
