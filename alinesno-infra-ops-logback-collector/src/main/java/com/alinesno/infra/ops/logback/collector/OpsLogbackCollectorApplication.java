package com.alinesno.infra.ops.logback.collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OpsLogbackCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpsLogbackCollectorApplication.class, args);
	}

}