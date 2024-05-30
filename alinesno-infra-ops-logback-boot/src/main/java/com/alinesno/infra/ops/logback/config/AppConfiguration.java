package com.alinesno.infra.ops.logback.config;

import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 应用配置类，用于启用和配置应用程序的各种组件和特性。
 *
 * @EnableInfraSsoApi 用于启用基础架构中单点登录（SSO）的API功能。
 * @ServletComponentScan 自动扫描并注册@WebServlet组件。
 * @MapperScan 指定mybatis mapper接口所在的包。
 * @EnableAsync 启用异步任务处理。
 * @EnableScheduling 启用计划任务。
 * @Configuration 表明这是一个配置类，可以提供Bean的定义和配置。
 */
@EnableActable
@EnableInfraSsoApi
@ServletComponentScan
@MapperScan("com.alinesno.infra.ops.logback.mapper")
@EnableAsync
@EnableScheduling
@Configuration
public class AppConfiguration {

}
