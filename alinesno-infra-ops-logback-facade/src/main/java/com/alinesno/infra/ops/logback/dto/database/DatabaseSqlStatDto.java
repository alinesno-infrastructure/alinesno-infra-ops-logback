package com.alinesno.infra.ops.logback.dto.database;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode(callSuper = true)
@Data
public class DatabaseSqlStatDto extends BaseDto  {

    private long databaseLogId; // 数据库日志ID
    private String sql; // SQL语句
    private int executeCount; // 执行次数
    private long executeMillisMax; // 最大执行时间（毫秒）
    private long executeMillisTotal; // 总执行时间（毫秒）
    private long executeErrorCount; // 执行错误次数
    private int runningCount; // 运行中数量
    private int concurrentMax; // 并发最大数量
    private int fetchRowCount;// 获取行数
    private int fetchRowCountMax; // 获取行数最大值
    private int updateCount; // 更新次数
    private int updateCountMax; // 更新次数最大值
    private int inTransactionCount; // 事务中数量
    private int clobOpenCount;// CLOB打开数量
    private int blobOpenCount;// BLOB打开数量

    private List<Integer> fetchRowHistogram;// 获取行数直方图
    private List<Integer> updateHistogram; // 更新次数直方图
    private List<Integer> executeHistogram; // 执行时间直方图
    private List<Integer> executeAndResultHoldHistogram; // 执行与结果保持时间直方图

}