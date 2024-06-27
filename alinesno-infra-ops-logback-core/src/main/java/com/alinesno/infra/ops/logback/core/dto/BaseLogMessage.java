package com.alinesno.infra.ops.logback.core.dto;

import lombok.Data;

/**
 * className：BaseLogMessage
 * description：
 * time：2020-05-11.15:28
 *
 * @author Tank
 * @author luoxiaodong
 * @version 1.0.0
 */
@Data
public class BaseLogMessage {
    /**
     * 记录服务IP
     */
    private String serverName;

    /**
     * 追踪码
     */
    private String traceId;

    /**
     * 应用名
     */
    private String appName;

    /**
     * 应用环境
     */
    private String env;
    
    /**
     * 用户密钥
     */
    private String userKey ;

    /**
     * 方法名
     */
    private String method;

}
