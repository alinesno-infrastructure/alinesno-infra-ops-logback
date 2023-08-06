package com.alinesno.infra.ops.logback.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;

import java.sql.Timestamp;

/**
 * Nginx访问日志实体类
 * 用于记录Nginx访问日志
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("nginx_access_log") // 指定数据库表名
public class NginxAccessLogEntity extends InfraBaseEntity {

    // 时间戳
    @TableField("timestamp")
    private Timestamp timestamp;

    // 客户端IP地址
    @TableField("client_ip_address")
    private String clientIpAddress;

    // 请求方法
    @TableField("request_method")
    private String requestMethod;

    // 请求URL
    @TableField("request_url")
    private String requestUrl;

    // HTTP协议版本
    @TableField("http_version")
    private String httpVersion;

    // 状态码
    @TableField("status_code")
    private int statusCode;

    // 响应大小
    @TableField("response_size")
    private long responseSize;

    // 引荐来源
    @TableField("referer")
    private String referer;

    // 用户代理
    @TableField("user_agent")
    private String userAgent;

    // 响应时间
    @TableField("response_time")
    private long responseTime;

    // 请求头
    @TableField("request_headers")
    private String requestHeaders;

    // 响应头
    @TableField("response_headers")
    private String responseHeaders;

    // 请求体
    @TableField("request_body")
    private String requestBody;

    // 响应体
    @TableField("response_body")
    private String responseBody;

    // 访问日志类型
    @TableField("access_log_type")
    private String accessLogType;

    // 主机名
    @TableField("hostname")
    private String hostname;

    // 端口号
    @TableField("port")
    private int port;

    // 域名
    @TableField("domain")
    private String domain;

    // 请求协议
    @TableField("request_protocol")
    private String requestProtocol;

    // 请求时间
    @TableField("request_time")
    private Timestamp requestTime;

    // 响应时间
    @TableField("response_time_stamp")
    private Timestamp responseTimeStamp;

    // 服务器名称
    @TableField("server_name")
    private String serverName;

    // 缓存状态
    @TableField("cache_status")
    private String cacheStatus;

    // 前端代理
    @TableField("frontend_proxy")
    private String frontendProxy;

    // 后端服务器
    @TableField("backend_server")
    private String backendServer;

    // SSL协议版本
    @TableField("ssl_protocol_version")
    private String sslProtocolVersion;

    // SSL加密算法
    @TableField("ssl_cipher")
    private String sslCipher;

    // 请求时间区间
    @TableField("request_time_range")
    private String requestTimeRange;

    // 请求时长
    @TableField("request_duration")
    private long requestDuration;

    // 响应类型
    @TableField("response_type")
    private String responseType;

    // Getters and Setters
}
