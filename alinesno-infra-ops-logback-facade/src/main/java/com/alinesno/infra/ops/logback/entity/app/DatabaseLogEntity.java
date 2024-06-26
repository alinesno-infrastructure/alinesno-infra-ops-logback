package com.alinesno.infra.ops.logback.entity.app;

import com.alinesno.infra.ops.logback.entity.BaseLogEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据库操作日志实体类
 * 用于记录MyBatis-Plus操作的数据库日志
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("database_log") // 指定数据库表名
@Data
public class DatabaseLogEntity extends BaseLogEntity {

    @TableField("jdbc_url")
    @ColumnType(length = 255)
    @ColumnComment("URL地址")
    private String url;

    @TableField("db_type")
    @ColumnType(length = 50)
    @ColumnComment("数据库类型")
    private String dbType;

    @TableField("jdbc_name")
    @ColumnType(length = 100)
    @ColumnComment("名称")
    private String name;

    @TableField("active_count")
    @ColumnType(length = 10)
    @ColumnComment("活动连接数")
    private int activeCount;

    @TableField("active_peak")
    @ColumnType(length = 10)
    @ColumnComment("活动连接峰值")
    private int activePeak;

    @TableField("active_peak_time")
    @ColumnType(length = 20)
    @ColumnComment("活动连接峰值时间")
    private long activePeakTime;

    @TableField("pooling_count")
    @ColumnType(length = 10)
    @ColumnComment("连接池中连接数")
    private int poolingCount;

    @TableField("pooling_peak")
    @ColumnType(length = 10)
    @ColumnComment("连接池中连接峰值")
    private int poolingPeak;

    @TableField("pooling_peak_time")
    @ColumnType(length = 20)
    @ColumnComment("连接池中连接峰值时间")
    private long poolingPeakTime;

    @TableField("connect_count")
    @ColumnType(length = 10)
    @ColumnComment("连接次数")
    private int connectCount;

    @TableField("close_count")
    @ColumnType(length = 10)
    @ColumnComment("关闭连接次数")
    private int closeCount;

    @TableField("wait_thread_count")
    @ColumnType(length = 10)
    @ColumnComment("等待线程数量")
    private int waitThreadCount;

    @TableField("not_empty_wait_count")
    @ColumnType(length = 10)
    @ColumnComment("非空等待数量")
    private int notEmptyWaitCount;

    @TableField("not_empty_wait_millis")
    @ColumnType(length = 20)
    @ColumnComment("非空等待时间（毫秒）")
    private long notEmptyWaitMillis;

    @TableField("logic_connect_error_count")
    @ColumnType(length = 10)
    @ColumnComment("逻辑连接错误次数")
    private int logicConnectErrorCount;

    @TableField("physical_connect_count")
    @ColumnType(length = 10)
    @ColumnComment("物理连接次数")
    private int physicalConnectCount;

    @TableField("physical_close_count")
    @ColumnType(length = 10)
    @ColumnComment("物理关闭连接次数")
    private int physicalCloseCount;

    @TableField("physical_connect_error_count")
    @ColumnType(length = 10)
    @ColumnComment("物理连接错误次数")
    private int physicalConnectErrorCount;

    @TableField("execute_count")
    @ColumnType(length = 10)
    @ColumnComment("执行次数")
    private int executeCount;

    @TableField("error_count")
    @ColumnType(length = 10)
    @ColumnComment("错误次数")
    private int errorCount;

    @TableField("commit_count")
    @ColumnType(length = 10)
    @ColumnComment("提交次数")
    private int commitCount;

    @TableField("rollback_count")
    @ColumnType(length = 10)
    @ColumnComment("回滚次数")
    private int rollbackCount;

    @TableField("pstmt_cache_hit_count")
    @ColumnType(length = 10)
    @ColumnComment("PreparedStatement缓存命中次数")
    private int pstmtCacheHitCount;

    @TableField("pstmt_cache_miss_count")
    @ColumnType(length = 10)
    @ColumnComment("PreparedStatement缓存未命中次数")
    private int pstmtCacheMissCount;

    @TableField("start_transaction_count")
    @ColumnType(length = 10)
    @ColumnComment("启动事务次数")
    private int startTransactionCount;

    @TableField("transaction_histogram")
    @ColumnType(length = 255)
    @ColumnComment("事务直方图")
    private String transactionHistogram;

    @TableField("connection_hold_time_histogram")
    @ColumnType(length = 255)
    @ColumnComment("连接保持时间直方图")
    private String connectionHoldTimeHistogram;

    @TableField("clob_open_count")
    @ColumnType(length = 10)
    @ColumnComment("Clob打开次数")
    private int clobOpenCount;

    @TableField("blob_open_count")
    @ColumnType(length = 10)
    @ColumnComment("Blob打开次数")
    private int blobOpenCount;

    @TableField("sql_skip_count")
    @ColumnType(length = 10)
    @ColumnComment("跳过SQL次数")
    private int sqlSkipCount;

    @TableField("keep_alive_check_count")
    @ColumnType(length = 10)
    @ColumnComment("保持活动检查次数")
    private int keepAliveCheckCount;

}
