package com.alinesno.infra.ops.logback.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 通用业务日志记录实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("business_log")
@Data
public class BusinessLogEntity extends InfraBaseEntity {

    // 日志ID
    @TableField("log_id")
	@ColumnType(length=10)
	@ColumnComment("日志ID")
    private String logId;

    // 时间戳
    @TableField("timestamp")
	@ColumnType(length=20)
	@ColumnComment("时间戳")
    private long timestamp;

    // 日志级别
    @TableField("log_level")
	@ColumnType(length=10)
	@ColumnComment("日志级别")
    private String logLevel;

    // 日志来源
    @TableField("log_source")
	@ColumnType(length=50)
	@ColumnComment("日志来源")
    private String logSource;

    // 用户ID
    @TableField("user_id")
	@ColumnType(length=50)
	@ColumnComment("用户ID")
    private String userId;

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

    // 操作描述
    @TableField("operation_description")
	@ColumnType(length=255)
	@ColumnComment("操作描述")
    private String operationDescription;

    // 请求参数
    @TableField("request_parameters")
	@ColumnType(length=255)
	@ColumnComment("请求参数")
    private String requestParameters;

    // 响应结果
    @TableField("response_result")
	@ColumnType(length=255)
	@ColumnComment("响应结果")
    private String responseResult;

    // 异常信息
    @TableField("exception_info")
	@ColumnType(length=255)
	@ColumnComment("异常信息")
    private String exceptionInfo;

    // IP地址
    @TableField("ip_address")
	@ColumnType(length=15)
	@ColumnComment("IP地址")
    private String ipAddress;

    // 设备信息
    @TableField("device_info")
	@ColumnType(length=255)
	@ColumnComment("设备信息")
    private String deviceInfo;

    // 地理位置
    @TableField("location")
	@ColumnType(length=255)
	@ColumnComment("地理位置")
    private String location;

    // 持续时间
    @TableField("duration")
	@ColumnType(length=255)
	@ColumnComment("持续时间")
    private long duration;

    // 受影响对象
    @TableField("affected_objects")
	@ColumnType(length=255)
	@ColumnComment("受影响对象")
    private String affectedObjects;

    // 日志标签
    @TableField("log_tags")
	@ColumnType(length=255)
	@ColumnComment("日志标签")
    private String logTags;

    // 日志附加信息
    @TableField("additional_info")
	@ColumnType(length=255)
	@ColumnComment("日志附加信息")
    private String additionalInfo;

    // 日志来源应用
    @TableField("source_application")
	@ColumnType(length=50)
	@ColumnComment("日志来源应用")
    private String sourceApplication;
}
