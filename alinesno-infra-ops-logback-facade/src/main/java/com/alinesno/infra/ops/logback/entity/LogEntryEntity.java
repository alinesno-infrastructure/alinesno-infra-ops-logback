package com.alinesno.infra.ops.logback.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;

import java.sql.Timestamp;

/**
 * 日志实体类
 * 生成日志记录的实体类
 * 包含各种日志相关的字段
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("log_entry") // 指定数据库表名
public class LogEntryEntity extends InfraBaseEntity {

    // 时间戳
    @TableField("timestamp")
    private Timestamp timestamp;

    // 日志级别
    @TableField("log_level")
    private String logLevel;

    // 日志来源
    @TableField("logger_name")
    private String loggerName;

    // 线程名
    @TableField("thread_name")
    private String threadName;

    // 日志消息
    @TableField("log_message")
    private String logMessage;

    // 异常信息
    @TableField("exception")
    private String exception;

    // 用户名
    @TableField("username")
    private String username;

    // IP地址
    @TableField("ip_address")
    private String ipAddress;

    // 请求URL
    @TableField("request_url")
    private String requestUrl;

    // 请求方法
    @TableField("request_method")
    private String requestMethod;

    // 请求参数
    @TableField("request_parameters")
    private String requestParameters;

    // 响应代码
    @TableField("response_code")
    private int responseCode;

    // 响应时间
    @TableField("response_time")
    private long responseTime;

    // 服务器名
    @TableField("server_name")
    private String serverName;

    // 应用程序名
    @TableField("application_name")
    private String applicationName;

    // 日志ID
    @TableField("log_id")
    private String logId;

    // 日志标签
    @TableField("log_tags")
    private String logTags;

    // 日志来源应用程序
    @TableField("source_application")
    private String sourceApplication;

    // 日志分类
    @TableField("log_category")
    private String logCategory;

    // 日志位置
    @TableField("log_location")
    private String logLocation;

    // 日志上下文
    @TableField("log_context")
    private String logContext;

    // 日志标记
    @TableField("log_markers")
    private String logMarkers;

    // 日志附加数据
    @TableField("log_extra_data")
    private String logExtraData;

    // 日志持续时间
    @TableField("log_duration")
    private long logDuration;

    // 日志环境
    @TableField("log_environment")
    private String logEnvironment;

    // 日志标准化字段
    @TableField("standardized_fields")
    private String standardizedFields;

    // Getters and Setters
}
