package com.alinesno.infra.ops.logback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
@SpringBootApplication
public class OpsLogbackApplication {

	/**
	 * 应用程序的入口点。
	 *
	 * @param args 命令行参数，传递给SpringApplication的运行方法。
	 *
	 * 本方法通过调用SpringApplication的run方法来启动Spring Boot应用程序。
	 * 它指定了应用程序的主类OpsLogbackApplication和传入的命令行参数。
	 */
	public static void main(String[] args) {
		SpringApplication.run(OpsLogbackApplication.class, args);
	}

}