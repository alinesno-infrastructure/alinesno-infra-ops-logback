package com.alinesno.infra.ops.logback.config;

//import com.alibaba.druid.pool.DruidDataSourceStatLoggerImpl;
import com.alibaba.druid.pool.DruidDataSourceStatLoggerImpl;
import com.alibaba.druid.proxy.jdbc.DataSourceProxy;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

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
@EnableInfraSsoApi
@ServletComponentScan
@MapperScan("com.alinesno.infra.ops.logback.mapper")
@EnableAsync
@EnableScheduling
@Configuration
public class AppConfiguration {

    @Autowired
    private MybatisPlusInterceptor mybatisPlusInterceptor;

    /**
     * 使用alibaba druid日志配置，用于记录日志服务
     * @return
     */
    @Bean
    public DruidDataSourceStatLoggerImpl getDruidDataSourceStatLoggerImpl(){
        return new DruidDataSourceStatLoggerImpl() ;
    }

    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("primaryDataSource") DataSource primaryDataSource) throws Exception {

        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setPlugins(new Interceptor[]{mybatisPlusInterceptor});
        factoryBean.setDataSource(primaryDataSource);

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        factoryBean.setConfiguration(configuration);
        factoryBean.setTransactionFactory(new SpringManagedTransactionFactory());

        return factoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
       return new SqlSessionTemplate(sqlSessionFactory) ;
    }

}
