package com.alinesno.infra.ops.logback.core.druid;

import com.alibaba.druid.pool.DruidDataSourceStatLoggerAdapter;
import com.alibaba.druid.pool.DruidDataSourceStatLoggerImpl;
import com.alibaba.druid.pool.DruidDataSourceStatValue;
import com.alibaba.druid.stat.JdbcSqlStatValue;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alinesno.infra.ops.logback.core.utils.GfJsonUtil;
import com.alinesno.infra.ops.logback.core.utils.HttpClient;
import com.alinesno.infra.ops.logback.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;

import static com.alibaba.druid.util.JdbcSqlStatUtils.rtrim;

/**
 * 日志服务拦截和执久化配置
 */
public class AgentDruidDataSourceStatLoggerImpl extends DruidDataSourceStatLoggerAdapter {

    private static Log LOG = LogFactory.getLog(DruidDataSourceStatLoggerImpl.class);

    private Log logger = LOG;

    @Value("${alinesno.ops.logback.restHost:}")
    private String restHost;

    public AgentDruidDataSourceStatLoggerImpl(){
    }

    public AgentDruidDataSourceStatLoggerImpl(String restHost){
        this.restHost = restHost;
    }

    /**
     * @since 0.2.21
     */
    @Override
    public void configFromProperties(Properties properties) {
        String property = properties.getProperty("druid.stat.loggerName");
        if (property != null && !property.isEmpty()) {
            setLoggerName(property);
        }
    }

    @Override
    public void setLoggerName(String loggerName) {
        logger = LogFactory.getLog(loggerName);
    }

    @Override
    public void setLogger(Log logger) {
        if (logger == null) {
            throw new IllegalArgumentException("logger can not be null");
        }
        this.logger = logger;
    }

    public boolean isLogEnable() {
        return logger.isInfoEnabled();
    }

    public void log(String value) {
        logger.info(value);
    }

    @Override
    public void log(DruidDataSourceStatValue statValue) {
        if (!isLogEnable()) {
            return;
        }
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        map.put("url", statValue.getUrl());
        map.put("dbType", statValue.getDbType());
        map.put("name", statValue.getName());
        map.put("activeCount", statValue.getActiveCount());

        if (statValue.getActivePeak() > 0) {
            map.put("activePeak", statValue.getActivePeak());
            map.put("activePeakTime", statValue.getActivePeakTime());
        }
        map.put("poolingCount", statValue.getPoolingCount());
        if (statValue.getPoolingPeak() > 0) {
            map.put("poolingPeak", statValue.getPoolingPeak());
            map.put("poolingPeakTime", statValue.getPoolingPeakTime());
        }
        map.put("connectCount", statValue.getConnectCount());
        map.put("closeCount", statValue.getCloseCount());

        if (statValue.getWaitThreadCount() > 0) {
            map.put("waitThreadCount", statValue.getWaitThreadCount());
        }

        if (statValue.getNotEmptyWaitCount() > 0) {
            map.put("notEmptyWaitCount", statValue.getNotEmptyWaitCount());
        }

        if (statValue.getNotEmptyWaitMillis() > 0) {
            map.put("notEmptyWaitMillis", statValue.getNotEmptyWaitMillis());
        }

        if (statValue.getLogicConnectErrorCount() > 0) {
            map.put("logicConnectErrorCount", statValue.getLogicConnectErrorCount());
        }

        if (statValue.getPhysicalConnectCount() > 0) {
            map.put("physicalConnectCount", statValue.getPhysicalConnectCount());
        }

        if (statValue.getPhysicalCloseCount() > 0) {
            map.put("physicalCloseCount", statValue.getPhysicalCloseCount());
        }

        if (statValue.getPhysicalConnectErrorCount() > 0) {
            map.put("physicalConnectErrorCount", statValue.getPhysicalConnectErrorCount());
        }

        if (statValue.getExecuteCount() > 0) {
            map.put("executeCount", statValue.getExecuteCount());
        }

        if (statValue.getErrorCount() > 0) {
            map.put("errorCount", statValue.getErrorCount());
        }

        if (statValue.getCommitCount() > 0) {
            map.put("commitCount", statValue.getCommitCount());
        }

        if (statValue.getRollbackCount() > 0) {
            map.put("rollbackCount", statValue.getRollbackCount());
        }

        if (statValue.getPstmtCacheHitCount() > 0) {
            map.put("pstmtCacheHitCount", statValue.getPstmtCacheHitCount());
        }

        if (statValue.getPstmtCacheMissCount() > 0) {
            map.put("pstmtCacheMissCount", statValue.getPstmtCacheMissCount());
        }

        if (statValue.getStartTransactionCount() > 0) {
            map.put("startTransactionCount", statValue.getStartTransactionCount());
            map.put("transactionHistogram", rtrim(statValue.getTransactionHistogram()));
        }

        if (statValue.getConnectCount() > 0) {
            map.put("connectionHoldTimeHistogram", rtrim(statValue.getConnectionHoldTimeHistogram()));
        }

        if (statValue.getClobOpenCount() > 0) {
            map.put("clobOpenCount", statValue.getClobOpenCount());
        }

        if (statValue.getBlobOpenCount() > 0) {
            map.put("blobOpenCount", statValue.getBlobOpenCount());
        }

        if (statValue.getSqlSkipCount() > 0) {
            map.put("sqlSkipCount", statValue.getSqlSkipCount());
        }

        ArrayList<Map<String, Object>> sqlList = new ArrayList<Map<String, Object>>();
        if (!statValue.getSqlList().isEmpty()) {
            for (JdbcSqlStatValue sqlStat : statValue.getSqlList()) {
                Map<String, Object> sqlStatMap = new LinkedHashMap<String, Object>();
                sqlStatMap.put("sql", sqlStat.getSql());

                if (sqlStat.getExecuteCount() > 0) {
                    sqlStatMap.put("executeCount", sqlStat.getExecuteCount());
                    sqlStatMap.put("executeMillisMax", sqlStat.getExecuteMillisMax());
                    sqlStatMap.put("executeMillisTotal", sqlStat.getExecuteMillisTotal());

                    sqlStatMap.put("executeHistogram", rtrim(sqlStat.getExecuteHistogram()));
                    sqlStatMap.put("executeAndResultHoldHistogram", rtrim(sqlStat.getExecuteAndResultHoldHistogram()));
                }

                long executeErrorCount = sqlStat.getExecuteErrorCount();
                if (executeErrorCount > 0) {
                    sqlStatMap.put("executeErrorCount", executeErrorCount);
                }

                int runningCount = sqlStat.getRunningCount();
                if (runningCount > 0) {
                    sqlStatMap.put("runningCount", runningCount);
                }

                int concurrentMax = sqlStat.getConcurrentMax();
                if (concurrentMax > 0) {
                    sqlStatMap.put("concurrentMax", concurrentMax);
                }

                if (sqlStat.getFetchRowCount() > 0) {
                    sqlStatMap.put("fetchRowCount", sqlStat.getFetchRowCount());
                    sqlStatMap.put("fetchRowCountMax", sqlStat.getFetchRowCountMax());
                    sqlStatMap.put("fetchRowHistogram", rtrim(sqlStat.getFetchRowHistogram()));
                }

                if (sqlStat.getUpdateCount() > 0) {
                    sqlStatMap.put("updateCount", sqlStat.getUpdateCount());
                    sqlStatMap.put("updateCountMax", sqlStat.getUpdateCountMax());
                    sqlStatMap.put("updateHistogram", rtrim(sqlStat.getUpdateHistogram()));
                }

                if (sqlStat.getInTransactionCount() > 0) {
                    sqlStatMap.put("inTransactionCount", sqlStat.getInTransactionCount());
                }

                if (sqlStat.getClobOpenCount() > 0) {
                    sqlStatMap.put("clobOpenCount", sqlStat.getClobOpenCount());
                }

                if (sqlStat.getBlobOpenCount() > 0) {
                    sqlStatMap.put("blobOpenCount", sqlStat.getBlobOpenCount());
                }

                sqlList.add(sqlStatMap);
            }

            map.put("sqlList", sqlList);
        }

        if (statValue.getKeepAliveCheckCount() > 0) {
            map.put("keepAliveCheckCount", statValue.getKeepAliveCheckCount());
        }

        String text = JSONUtils.toJSONString(map);

        log(text);
        sendOpsLogback(text) ;
    }

    private static final Queue<String> messageQueue = new LinkedList<>();

    /**
     * 发送日志到日志服务中心
     * @param text
     */
    private void sendOpsLogback(String text) {

        messageQueue.add(text) ;

        if(StringUtils.isEmpty(restHost)){
            logger.warn("日志服务地址未配置");
            return ;
        }

        String path = "v1/api/collector/databaseLog";
        String url = restHost.endsWith("/") ? restHost+ path : restHost+ "/" + path ;

        while (!messageQueue.isEmpty())   {
            String message = messageQueue.poll();
            try{
                String param = GfJsonUtil.toJSONString(message);
                logger.debug("url = " + url + " , 消息内容:" + param);
                HttpClient.doPostBody(url, param);
            }catch (Exception e){
                logger.error("发送日志到日志服务中心失败:" + e.getMessage());
                // 发送异常时，将消息重新加入队列
                messageQueue.add(message);
            }
        }
    }

}