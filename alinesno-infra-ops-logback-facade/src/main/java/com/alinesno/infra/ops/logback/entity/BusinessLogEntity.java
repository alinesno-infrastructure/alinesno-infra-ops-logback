package com.alinesno.infra.ops.logback.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 通用业务日志记录实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("business_log")
public class BusinessLogEntity extends InfraBaseEntity {

    // 日志ID
    @TableField("log_id")
    private String logId;

    // 时间戳
    @TableField("timestamp")
    private long timestamp;

    // 日志级别
    @TableField("log_level")
    private String logLevel;

    // 日志来源
    @TableField("log_source")
    private String logSource;

    // 用户ID
    @TableField("user_id")
    private String userId;

    // 操作类型
    @TableField("operation_type")
    private String operationType;

    // 操作对象
    @TableField("operation_object")
    private String operationObject;

    // 操作描述
    @TableField("operation_description")
    private String operationDescription;

    // 请求参数
    @TableField("request_parameters")
    private String requestParameters;

    // 响应结果
    @TableField("response_result")
    private String responseResult;

    // 异常信息
    @TableField("exception_info")
    private String exceptionInfo;

    // IP地址
    @TableField("ip_address")
    private String ipAddress;

    // 设备信息
    @TableField("device_info")
    private String deviceInfo;

    // 地理位置
    @TableField("location")
    private String location;

    // 持续时间
    @TableField("duration")
    private long duration;

    // 受影响对象
    @TableField("affected_objects")
    private String affectedObjects;

    // 日志标签
    @TableField("log_tags")
    private String logTags;

    // 日志附加信息
    @TableField("additional_info")
    private String additionalInfo;

    // 日志来源应用
    @TableField("source_application")
    private String sourceApplication;

    // Getters and Setters


    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getLogSource() {
        return logSource;
    }

    public void setLogSource(String logSource) {
        this.logSource = logSource;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    public String getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(String requestParameters) {
        this.requestParameters = requestParameters;
    }

    public String getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(String responseResult) {
        this.responseResult = responseResult;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getAffectedObjects() {
        return affectedObjects;
    }

    public void setAffectedObjects(String affectedObjects) {
        this.affectedObjects = affectedObjects;
    }

    public String getLogTags() {
        return logTags;
    }

    public void setLogTags(String logTags) {
        this.logTags = logTags;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getSourceApplication() {
        return sourceApplication;
    }

    public void setSourceApplication(String sourceApplication) {
        this.sourceApplication = sourceApplication;
    }
}