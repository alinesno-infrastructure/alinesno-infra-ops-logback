package com.alinesno.infra.ops.logback.dto.database;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode(callSuper = true)
@Data
public class DatabaseLogDto extends BaseDto {

    private String url; // URL地址
    private String dbType; // 数据库类型
    private String name; // 名称
    private int activeCount; // 活动连接数
    private int activePeak; // 活动连接峰值
    private long activePeakTime; // 活动连接峰值时间
    private int poolingCount; // 连接池中连接数
    private int poolingPeak; // 连接池中连接峰值
    private long poolingPeakTime; // 连接池中连接峰值时间
    private int connectCount; // 连接次数
    private int closeCount; // 关闭连接次数
    private int waitThreadCount; // 等待线程数量
    private int notEmptyWaitCount; // 非空等待数量
    private long notEmptyWaitMillis; // 非空等待时间（毫秒）
    private int logicConnectErrorCount; // 逻辑连接错误次数
    private int physicalConnectCount; // 物理连接次数
    private int physicalCloseCount; // 物理关闭连接次数
    private int physicalConnectErrorCount ; // 物理连接错误次数
    private int executeCount; // 执行次数
    private int errorCount; // 错误次数
    private int commitCount; // 提交次数
    private int rollbackCount; // 回滚次数
    private int pstmtCacheHitCount; // PreparedStatement缓存命中次数
    private int pstmtCacheMissCount; // PreparedStatement缓存未命中次数
    private int startTransactionCount; // 启动事务次数
    private List<Integer> transactionHistogram; // 事务直方图
    private List<Integer> connectionHoldTimeHistogram; // 连接保持时间直方图
    private int clobOpenCount; // Clob打开次数
    private int blobOpenCount; // Blob打开次数
    private int sqlSkipCount; // 跳过SQL次数
    private int keepAliveCheckCount; // 保持活动检查次数

    private List<DatabaseSqlStatDto> sqlList ;

}
