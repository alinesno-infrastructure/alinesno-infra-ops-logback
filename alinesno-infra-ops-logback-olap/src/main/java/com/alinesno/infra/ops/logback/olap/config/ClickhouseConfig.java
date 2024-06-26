package com.alinesno.infra.ops.logback.olap.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
 
import javax.sql.DataSource;

/**
 * enabled: true
 * driverClassName: ru.yandex.clickhouse.ClickHouseDriver
 * url: jdbc:clickhouse://127.0.0.1:8123/xx?max_result_bytes=10000
 * username: xxx
 * paswword: xxx
 * initialSize: 10
 * validationQuery: SELECT 1
 * maxActive: 100
 * minIdle: 10
 * maxWait: 6000
 */
@Configuration
@Data
public class ClickhouseConfig {

    @Value("${alinesno.ops.logback.clickhouse.driverClassName}")
    private String driverClassName;

    @Value("${alinesno.ops.logback.clickhouse.url}")
    private String url;

    @Value("${alinesno.ops.logback.clickhouse.username}")
    private String username;

    @Value("${alinesno.ops.logback.clickhouse.password}")
    private String password;

    @Value("${alinesno.ops.logback.clickhouse.initialSize}")
    private Integer initialSize;

    @Value("${alinesno.ops.logback.clickhouse.minIdle}")
    private Integer minIdle;

    @Value("${alinesno.ops.logback.clickhouse.maxActive}")
    private Integer maxActive;

    @Value("${alinesno.ops.logback.clickhouse.maxWait}")
    private Integer maxWait;

    @Value("${alinesno.ops.logback.clickhouse.validationQuery}")
    private String validationQuery;

    @Bean(name = "clickhouseDataSource")
    public DataSource clickhouseDataSource() {
        DruidDataSource ck = new DruidDataSource();
        ck.setDbType(driverClassName);
        ck.setUrl(url);
        ck.setUsername(username);
        ck.setPassword(password);
        ck.setInitialSize(initialSize);
        ck.setMinIdle(minIdle);
        ck.setMaxActive(maxActive);
        ck.setMaxWait(maxWait);
        ck.setValidationQuery(validationQuery);
        return ck;
    }

    @Bean(name = "clickHouseTemplate")
    public JdbcTemplate clickhouseTemplate(@Qualifier("clickhouseDataSource") DataSource clickhouseDataSource) {
        JdbcTemplate ck = new JdbcTemplate(clickhouseDataSource);
        ck.setResultsMapCaseInsensitive(true);
        return ck;
    }
}