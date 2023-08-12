package com.alinesno.infra.ops.logback.core.constants;

import java.util.Arrays;
import java.util.List;

/**
 * 日志参数
 * @author luoxiaodong
 * @version 1.0.0
 */
public class MessageConstant {

    public final static String LOG_KEY_LOGGER = "infra_logger_list";
    public final static String LOG_KEY_OS = "infra_logger_os";

    public final static String LOG_KEY_COMPRESS = "infra_log_list_compress";

    /**
     * 链路日志存入ES的索引后缀
     */
    public final static String LOG_KEY_TRACE = "infra_trace_list";

    public final static String LOG_KEY_TRACE_COMPRESS = "infra_trace_list_compress";

    public final static String ES_INDEX = "infra_log_";
    public final static String LOG_TYPE_RUN = "run";
    public final static String LOG_TYPE_TRACE = "trace";
    public final static String DELIM_STR = "{}";
    public final static String TRACE_ID = "traceId";
    /**
     * 默认扩展
     */
    public final static String DEFAULT_EXPAND = "infra";
    /**
     * Sleuth 扩展
     */
    public final static String SLEUTH_EXPAND = "sleuth";
    /**
     * Sleuth 扩展
     */
    public final static String MDC_EXPAND = "mdc";
    /**
     * 所有支持的扩展
     */
    public final static List<String> EXPANDS = Arrays.asList("infra", "sleuth", "mdc");
    /**
     * redis 默认端口号
     */
    public final static Integer REDIS_DEFAULT_PORT = 6379;
    /**
     * 错误报警规则key
     */
    public static final String WARN_RULE_KEY = "infra:warnRule";
    /**
     * 配置扩展字段的APPNAME列表
     */
    public static final String EXTEND_APP_KEY = "infra:extend:appName";
    /**
     * 扩展字段列表
     */
    public static final String EXTEND_APP_MAP_KEY = "infra:extend:";
    /**
     * 错误日志监控统计key
     */
    public static final String infra_MONITOR_KEY = "infra:monitor:";
    /**
     * 错误日志监控统计key对应的map里的key time
     */
    public static final String infra_MONITOR_KEY_MAP_FILED_TIME = "time";
    /**
     * 错误日志监控统计key对应的map里的key count
     */
    public static final String infra_MONITOR_KEY_MAP_FILED_COUNT = "count";
    /**
     * 记录报警日志的key
     */
    public static final String infra_MONITOR_MESSAGE_KEY = "infra_monitor_message_key";

    /**
     * sql审计日志
     */
	public static final String LOG_TYPE_SQL_AUDIT = "sql_audit";

	/**
	 * 业务指标索引
	 */
	public static final String LOG_TYPE_BUS_AUDIT = "bus_audit" ;
	
	/**
	 * 前端日志索引
	 */
	public static final String LOG_TYPE_BUS_NGINX = "nginx_audit" ;

    /**
     * 1 高性能模式，2 全信息模式
     */
    public static int RUN_MODEL = 1;

}
