package com.alinesno.infra.ops.logback.core.bus;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "alinesno.ops.logback")
public class LoggerProperties {

    /**
     * 项目代码
     */
    private String projectCode ;

    /**
     * 服务请求地址
     */
    private String kafkaServers = "localhost:9092" ;

    /**
     * 服务请求地址
     */
    private String restHost = "http://localhost:30405" ;

    /**
     * 全局的请求连接超时时间，单位为毫秒
     */
    private Integer connectTimeout = 45*1000;

}
