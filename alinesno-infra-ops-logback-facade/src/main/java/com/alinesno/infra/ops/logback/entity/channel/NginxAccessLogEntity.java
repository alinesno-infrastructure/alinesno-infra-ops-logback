package com.alinesno.infra.ops.logback.entity.channel;

import com.alinesno.infra.ops.logback.entity.BaseLogEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Timestamp;

/**
 * Nginx访问日志实体类
 * 用于记录Nginx访问日志
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("nginx_access_log") // 指定数据库表名
@Data
public class NginxAccessLogEntity extends BaseLogEntity {

    // 时间戳
    @TableField("timestamp")
	@ColumnType(length=20)
	@ColumnComment("时间戳")
    private Timestamp timestamp;

    // 客户端IP地址
    @TableField("client_ip_address")
	@ColumnType(length=15)
	@ColumnComment("客户端IP地址")
    private String clientIpAddress;

    // 请求方法
    @TableField("request_method")
	@ColumnType(length=4)
	@ColumnComment("请求方法")
    private String requestMethod;

    // 请求URL
    @TableField("request_url")
	@ColumnType(length=255)
	@ColumnComment("请求URL")
    private String requestUrl;

    // HTTP协议版本
    @TableField("http_version")
	@ColumnType(length=255)
	@ColumnComment("HTTP协议版本")
    private String httpVersion;

    // 状态码
    @TableField("status_code")
	@ColumnType(length=255)
	@ColumnComment("状态码")
    private int statusCode;

    // 响应大小
    @TableField("response_size")
	@ColumnType(length=255)
	@ColumnComment("响应大小")
    private long responseSize;

    // 引荐来源
    @TableField("referer")
	@ColumnType(length=255)
	@ColumnComment("引荐来源")
    private String referer;

    // 用户代理
    @TableField("user_agent")
	@ColumnType(length=255)
	@ColumnComment("用户代理")
    private String userAgent;

    // 响应时间
    @TableField("response_time")
	@ColumnType(length=255)
	@ColumnComment("响应时间")
    private long responseTime;

    // 请求头
    @TableField("request_headers")
	@ColumnType(length=255)
	@ColumnComment("请求头")
    private String requestHeaders;

    // 响应头
    @TableField("response_headers")
	@ColumnType(length=255)
	@ColumnComment("响应头")
    private String responseHeaders;

    // 请求体
    @TableField("request_body")
	@ColumnType(length=255)
	@ColumnComment("请求体")
    private String requestBody;

    // 响应体
    @TableField("response_body")
	@ColumnType(length=255)
	@ColumnComment("响应体")
    private String responseBody;

    // 访问日志类型
    @TableField("access_log_type")
	@ColumnType(length=10)
	@ColumnComment("访问日志类型")
    private String accessLogType;

    // 主机名
    @TableField("hostname")
	@ColumnType(length=255)
	@ColumnComment("主机名")
    private String hostname;

    // 端口号
    @TableField("port")
	@ColumnType(length=4)
	@ColumnComment("端口号")
    private int port;

    // 域名
    @TableField("domain")
	@ColumnType(length=255)
	@ColumnComment("域名")
    private String domain;

    // 请求协议
    @TableField("request_protocol")
	@ColumnType(length=20)
	@ColumnComment("请求协议")
    private String requestProtocol;

    // 请求时间
    @TableField("request_time")
	@ColumnType(length=19)
	@ColumnComment("请求时间")
    private Timestamp requestTime;

    // 响应时间
    @TableField("response_time_stamp")
	@ColumnType(length=14)
	@ColumnComment("响应时间")
    private Timestamp responseTimeStamp;

    // 服务器名称
    @TableField("server_name")
	@ColumnType(length=255)
	@ColumnComment("服务器名称")
    private String serverName;

    // 缓存状态
    @TableField("cache_status")
	@ColumnType(length=1)
	@ColumnComment("缓存状态")
    private String cacheStatus;

    // 前端代理
    @TableField("frontend_proxy")
	@ColumnType(length=255)
	@ColumnComment("前端代理")
    private String frontendProxy;

    // 后端服务器
    @TableField("backend_server")
	@ColumnType(length=255)
	@ColumnComment("后端服务器")
    private String backendServer;

    // SSL协议版本
    @TableField("ssl_protocol_version")
	@ColumnType(length=10)
	@ColumnComment("SSL协议版本")
    private String sslProtocolVersion;

    // SSL加密算法
    @TableField("ssl_cipher")
	@ColumnType(length=255)
	@ColumnComment("SSL加密算法")
    private String sslCipher;

    // 请求时间区间
    @TableField("request_time_range")
	@ColumnType(length=20)
	@ColumnComment("请求时间区间")
    private String requestTimeRange;

    // 请求时长
    @TableField("request_duration")
	@ColumnType(length=10)
	@ColumnComment("请求时长")
    private long requestDuration;

    // 响应类型
    @TableField("response_type")
	@ColumnType(length=10)
	@ColumnComment("响应类型")
    private String responseType;
}
