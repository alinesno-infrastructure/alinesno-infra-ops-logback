package com.alinesno.infra.ops.logback.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 工具类
 *
 * @author WeiXiaoJin
 * @since 2018年8月5日 下午1:09:50
 */
@Component
public class SpringContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext app) throws BeansException {
		if (applicationContext == null) {
			applicationContext = app;
		}
	}

	// 获取applicationContext
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	// 通过name获取 Bean.
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);

	}

	// 通过class获取Bean.
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	public static <T> List<T> getObjectProvider(Class<T> requireType) {
		return applicationContext.getBeanProvider(requireType).stream().collect(Collectors.toList());
	}

	// 通过name,以及Clazz返回指定的Bean
	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}

	/**
	 * 获取spring上下文
	 */
	public static ApplicationContext context() {
		return getApplicationContext();
	}
}