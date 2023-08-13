package com.alinesno.infra.ops.logback.entity;

import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Timestamp;
import java.util.Map;

/**
 * 日志实体类
 * 生成日志记录的实体类
 * 包含各种日志相关的字段
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("a_log_record") // 指定数据库表名
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

    @TableField(exist = false) // 不映射到数据库表
    private Map<String, String> MDCPropertyMap; // MDC属性映射

    @TableField(exist = false) // 不映射到数据库表
    private JSONObject jvm; // JVM信息

    @TableField(exist = false) // 不映射到数据库表
    private JSONObject mem; // 内存信息

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

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
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

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(String requestParameters) {
        this.requestParameters = requestParameters;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogTags() {
        return logTags;
    }

    public void setLogTags(String logTags) {
        this.logTags = logTags;
    }

    public String getSourceApplication() {
        return sourceApplication;
    }

    public void setSourceApplication(String sourceApplication) {
        this.sourceApplication = sourceApplication;
    }

    public String getLogCategory() {
        return logCategory;
    }

    public void setLogCategory(String logCategory) {
        this.logCategory = logCategory;
    }

    public String getLogLocation() {
        return logLocation;
    }

    public void setLogLocation(String logLocation) {
        this.logLocation = logLocation;
    }

    public String getLogContext() {
        return logContext;
    }

    public void setLogContext(String logContext) {
        this.logContext = logContext;
    }

    public String getLogMarkers() {
        return logMarkers;
    }

    public void setLogMarkers(String logMarkers) {
        this.logMarkers = logMarkers;
    }

    public String getLogExtraData() {
        return logExtraData;
    }

    public void setLogExtraData(String logExtraData) {
        this.logExtraData = logExtraData;
    }

    public long getLogDuration() {
        return logDuration;
    }

    public void setLogDuration(long logDuration) {
        this.logDuration = logDuration;
    }

    public String getLogEnvironment() {
        return logEnvironment;
    }

    public void setLogEnvironment(String logEnvironment) {
        this.logEnvironment = logEnvironment;
    }

    public String getStandardizedFields() {
        return standardizedFields;
    }

    public void setStandardizedFields(String standardizedFields) {
        this.standardizedFields = standardizedFields;
    }

    public Map<String, String> getMDCPropertyMap() {
        return MDCPropertyMap;
    }

    public void setMDCPropertyMap(Map<String, String> MDCPropertyMap) {
        this.MDCPropertyMap = MDCPropertyMap;
    }

    public JSONObject getJvm() {
        return jvm;
    }

    public void setJvm(JSONObject jvm) {
        this.jvm = jvm;
    }

    public JSONObject getMem() {
        return mem;
    }

    public void setMem(JSONObject mem) {
        this.mem = mem;
    }
}
