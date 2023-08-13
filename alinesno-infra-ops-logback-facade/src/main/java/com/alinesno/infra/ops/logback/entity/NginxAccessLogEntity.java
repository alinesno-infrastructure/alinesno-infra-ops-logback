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


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getClientIpAddress() {
        return clientIpAddress;
    }

    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public long getResponseSize() {
        return responseSize;
    }

    public void setResponseSize(long responseSize) {
        this.responseSize = responseSize;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public String getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(String requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public String getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(String responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getAccessLogType() {
        return accessLogType;
    }

    public void setAccessLogType(String accessLogType) {
        this.accessLogType = accessLogType;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getRequestProtocol() {
        return requestProtocol;
    }

    public void setRequestProtocol(String requestProtocol) {
        this.requestProtocol = requestProtocol;
    }

    public Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Timestamp requestTime) {
        this.requestTime = requestTime;
    }

    public Timestamp getResponseTimeStamp() {
        return responseTimeStamp;
    }

    public void setResponseTimeStamp(Timestamp responseTimeStamp) {
        this.responseTimeStamp = responseTimeStamp;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getCacheStatus() {
        return cacheStatus;
    }

    public void setCacheStatus(String cacheStatus) {
        this.cacheStatus = cacheStatus;
    }

    public String getFrontendProxy() {
        return frontendProxy;
    }

    public void setFrontendProxy(String frontendProxy) {
        this.frontendProxy = frontendProxy;
    }

    public String getBackendServer() {
        return backendServer;
    }

    public void setBackendServer(String backendServer) {
        this.backendServer = backendServer;
    }

    public String getSslProtocolVersion() {
        return sslProtocolVersion;
    }

    public void setSslProtocolVersion(String sslProtocolVersion) {
        this.sslProtocolVersion = sslProtocolVersion;
    }

    public String getSslCipher() {
        return sslCipher;
    }

    public void setSslCipher(String sslCipher) {
        this.sslCipher = sslCipher;
    }

    public String getRequestTimeRange() {
        return requestTimeRange;
    }

    public void setRequestTimeRange(String requestTimeRange) {
        this.requestTimeRange = requestTimeRange;
    }

    public long getRequestDuration() {
        return requestDuration;
    }

    public void setRequestDuration(long requestDuration) {
        this.requestDuration = requestDuration;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
