package com.alinesno.infra.ops.logback;

import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
@EnableInfraSsoApi
@ServletComponentScan
@MapperScan("com.alinesno.infra.ops.logback.mapper")
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class OpsLogbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpsLogbackApplication.class, args);
	}

}