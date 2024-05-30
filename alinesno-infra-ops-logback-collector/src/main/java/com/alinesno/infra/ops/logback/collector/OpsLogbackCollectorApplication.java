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

	/**
	 * 程序的主入口函数。
	 *
	 * @param args 命令行传入的参数数组。
	 *
	 * 本函数通过调用SpringApplication.run方法来启动Spring应用。它指定了应用的入口类OpsLogbackCollectorApplication和启动参数args。
	 */
	public static void main(String[] args) {
	    SpringApplication.run(OpsLogbackCollectorApplication.class, args);
	}

}