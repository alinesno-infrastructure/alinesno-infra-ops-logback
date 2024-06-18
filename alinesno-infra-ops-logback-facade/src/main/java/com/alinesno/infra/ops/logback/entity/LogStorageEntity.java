package com.alinesno.infra.ops.logback.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * 通用日志实体类
 * 生成日志记录的实体类
 * 包含各种日志相关的字段
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("log_storage") // 指定数据库表名
@Data
public class LogStorageEntity extends BaseLogEntity {

    // 时间
    @TableField("timestamp")
	@ColumnType(length=30)
	@ColumnComment("时间戳")
    private long timestamp;

    // 日志级别
    @TableField("log_level")
	@ColumnType(length=10)
	@ColumnComment("日志级别")
    private String logLevel;

    // 日志来源
    @TableField("logger_name")
	@ColumnType(length=128)
	@ColumnComment("日志来源")
    private String loggerName;

    // 线程名
    @TableField("thread_name")
	@ColumnType(length=128)
	@ColumnComment("线程名")
    private String threadName;

    // 日志消息
    @TableField("log_message")
	@ColumnType(length=1024)
	@ColumnComment("日志消息")
    private String logMessage;

    // 异常信息
    @TableField("exception")
	@ColumnType(length=1024)
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

    // 请求URL
    @TableField("request_url")
	@ColumnType(length=255)
	@ColumnComment("请求URL")
    private String requestUrl;

    // 请求方法
    @TableField("request_method")
	@ColumnType(length=128)
	@ColumnComment("请求方法")
    private String requestMethod;

    // 请求参数
    @TableField("request_parameters")
	@ColumnType(length=255)
	@ColumnComment("请求参数")
    private String requestParameters;

    // 响应代码
    @TableField("response_code")
	@ColumnType(length=3)
	@ColumnComment("响应代码")
    private int responseCode;

    // 响应时间
    @TableField("response_time")
	@ColumnType(length=8)
	@ColumnComment("响应时间")
    private long responseTime;

    // 服务器名
    @TableField("server_name")
	@ColumnType(length=255)
	@ColumnComment("服务器名")
    private String serverName;

    // 日志ID
    @TableField("log_id")
	@ColumnType(length=10)
	@ColumnComment("日志ID")
    private String logId;

    // 日志标签
    @TableField("log_tags")
	@ColumnType(length=255)
	@ColumnComment("日志标签")
    private String logTags;

    // 日志来源应用程序
    @TableField("source_application")
	@ColumnType(length=255)
	@ColumnComment("日志来源应用程序")
    private String sourceApplication;

    // 日志分类
    @TableField("log_category")
	@ColumnType(length=50)
	@ColumnComment("日志分类")
    private String logCategory;

    // 日志位置
    @TableField("log_location")
	@ColumnType(length=255)
	@ColumnComment("日志位置")
    private String logLocation;

    // 日志上下文
    @TableField("log_context")
	@ColumnType(length=255)
	@ColumnComment("日志上下文")
    private String logContext;

    // 日志标记
    @TableField("log_markers")
	@ColumnType(length=255)
	@ColumnComment("日志标记")
    private String logMarkers;

    // 日志附加数据
    @TableField("log_extra_data")
	@ColumnType(length=255)
	@ColumnComment("日志附加数据")
    private String logExtraData;

    // 日志持续时间
    @TableField("log_duration")
	@ColumnType(length=8)
	@ColumnComment("日志持续时间")
    private long logDuration;

    // 日志环境
    @TableField("log_environment")
	@ColumnType(length=50)
	@ColumnComment("日志环境")
    private String logEnvironment;

    // 日志标准化字段
    @TableField("standardized_fields")
	@ColumnType(length=255)
	@ColumnComment("日志标准化字段")
    private String standardizedFields;

    @TableField(exist = false) // 不映射到数据库表
    private Map<String, String> MDCPropertyMap; // MDC属性映射

    @TableField(exist = false) // 不映射到数据库表
    private JSONObject jvm; // JVM信息

    @TableField(exist = false) // 不映射到数据库表
    private JSONObject mem; // 内存信息
}
