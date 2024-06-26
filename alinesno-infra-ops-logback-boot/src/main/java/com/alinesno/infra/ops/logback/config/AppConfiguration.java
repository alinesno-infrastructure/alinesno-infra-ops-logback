package com.alinesno.infra.ops.logback.config;

//import com.alibaba.druid.pool.DruidDataSourceStatLoggerImpl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alinesno.infra.common.facade.wrapper.mybatis.inject.DbMetaObjectHandler;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import com.alinesno.infra.ops.logback.core.bus.BusLogger;
import com.alinesno.infra.ops.logback.core.druid.AgentDruidDataSourceStatLoggerImpl;
import com.alinesno.infra.ops.logback.olap.repository.JdbcClickHouseRepository;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
@Slf4j
@MapperScan(basePackages = {"com.alinesno.infra.ops.logback.mapper" , "com.gitee.sunchenbin.mybatis.actable.dao.*"})
@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*" , "com.alinesno.infra.ops.logback"})
@EnableInfraSsoApi
@ServletComponentScan
@EnableAsync
@EnableScheduling
@Configuration
public class AppConfiguration implements CommandLineRunner {

    @Value("${alinesno.ops.logback.restHost:}")
    private String restHost;

    @Autowired
    private MybatisPlusInterceptor mybatisPlusInterceptor;

    @Autowired
    private JdbcClickHouseRepository jdbcClickHouseRepository ;

    @Override
    public void run(String... args) throws Exception {
        log.debug("jdbcClickhouse = {}" , jdbcClickHouseRepository);

        // 重要：记录账户余额不足的交易异常
        BusLogger.important("交易异常：账户余额不足，无法完成交易。账户号：123456，交易金额：$500，当前余额：$100");
        // 严重：记录交易金额超出限额的异常
        BusLogger.critical("交易异常：交易金额超出限额，风险较高。账户号：789012，交易金额：$10000，限额：$5000");
        // 低级：记录交易延迟，可能需要手动处理
        BusLogger.low("交易异常：交易延迟，可能需要手动处理。账户号：345678，交易金额：$200");
        // 普通：记录交易成功的消息
        BusLogger.normal("交易异常：交易成功，金额：$500，账户号：234567");
        // 紧急：记录因系统故障导致的交易失败
        BusLogger.emergency("交易异常：系统故障导致交易失败。请尽快处理。账户号：456789，交易金额：$1000");
    }

    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource primaryDataSource() throws SQLException {

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setInitialSize(50);
        dataSource.setMinIdle(10);
        dataSource.setMaxActive(200);
        dataSource.setMaxWait(10);
        dataSource.setValidationQuery("select 1");

        // -->>> sql日志监控统计_start -->>>
        dataSource.setFilters("stat,wall");
        dataSource.setTimeBetweenLogStatsMillis(5*1000);
        dataSource.setStatLogger(new AgentDruidDataSourceStatLoggerImpl(restHost));
        // -->>> sql日志监控统计_end -->>>

        return dataSource;
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
        factoryBean.setGlobalConfig(getGlobalConfig());
        factoryBean.setMapperLocations(resolveMapperLocations());

        factoryBean.setTransactionFactory(new SpringManagedTransactionFactory());

        return factoryBean.getObject();
    }

    public Resource[] resolveMapperLocations() {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        List<String> mapperLocations = new ArrayList<>();

        mapperLocations.add("classpath*:mapper/**/*.xml");

        List<Resource> resources = new ArrayList<>();
        for (String mapperLocation : mapperLocations) {
            try {
                Resource[] mappers = resourceResolver.getResources(mapperLocation);
                resources.addAll(Arrays.asList(mappers));
            } catch (IOException e) {
                log.error("Get myBatis resources happened exception", e);
            }
        }

        return resources.toArray(new Resource[0]);
    }

    public GlobalConfig getGlobalConfig(){
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setBanner(false) ;
        globalConfig.setMetaObjectHandler(new DbMetaObjectHandler()) ;

        return globalConfig ;
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory) ;
    }

}
