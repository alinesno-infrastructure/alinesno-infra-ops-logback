package com.alinesno.infra.ops.logback.entity.app;

import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@TableName("database_sql_stat") // 指定数据库表名
@Data
public class DatabaseSqlStatEntity extends BaseEntity {

    @TableField("database_log_id")
    @ColumnType(length = 10)
    @ColumnComment("数据库日志ID")
    private long databaseLogId;

    @TableField("execute_sql")
    @ColumnType(length = 1024)
    @ColumnComment("SQL语句")
    private String executeSql;

    @TableField("execute_count")
    @ColumnType(length = 10)
    @ColumnComment("执行次数")
    private int executeCount;

    @TableField("execute_millis_max")
    @ColumnType(length = 20)
    @ColumnComment("最大执行时间（毫秒）")
    private long executeMillisMax;

    @TableField("execute_millis_total")
    @ColumnType(length = 20)
    @ColumnComment("总执行时间（毫秒）")
    private long executeMillisTotal;

    @TableField("execute_histogram")
    @ColumnType(length = 255)
    @ColumnComment("执行时间直方图")
    private String executeHistogram;

    @TableField("execute_and_result_hold_histogram")
    @ColumnType(length = 255)
    @ColumnComment("执行与结果保持时间直方图")
    private String executeAndResultHoldHistogram;

    @TableField("execute_error_count")
    @ColumnType(length = 10)
    @ColumnComment("执行错误次数")
    private long executeErrorCount;

    @TableField("running_count")
    @ColumnType(length = 10)
    @ColumnComment("运行中数量")
    private int runningCount;

    @TableField("concurrent_max")
    @ColumnType(length = 10)
    @ColumnComment("并发最大数量")
    private int concurrentMax;

    @TableField("fetch_row_count")
    @ColumnType(length = 10)
    @ColumnComment("获取行数")
    private int fetchRowCount;

    @TableField("fetch_row_count_max")
    @ColumnType(length = 10)
    @ColumnComment("获取行数最大值")
    private int fetchRowCountMax;

    @TableField("fetch_row_histogram")
    @ColumnType(length = 255)
    @ColumnComment("获取行数直方图")
    private String fetchRowHistogram;

    @TableField("update_count")
    @ColumnType(length = 10)
    @ColumnComment("更新次数")
    private int updateCount;

    @TableField("update_count_max")
    @ColumnType(length = 10)
    @ColumnComment("更新次数最大值")
    private int updateCountMax;

    @TableField("update_histogram")
    @ColumnType(length = 255)
    @ColumnComment("更新次数直方图")
    private String updateHistogram;

    @TableField("in_transaction_count")
    @ColumnType(length = 10)
    @ColumnComment("事务中数量")
    private int inTransactionCount;

    @TableField("clob_open_count")
    @ColumnType(length = 10)
    @ColumnComment("CLOB打开数量")
    private int clobOpenCount;

    @TableField("blob_open_count")
    @ColumnType(length = 10)
    @ColumnComment("BLOB打开数量")
    private int blobOpenCount;

}