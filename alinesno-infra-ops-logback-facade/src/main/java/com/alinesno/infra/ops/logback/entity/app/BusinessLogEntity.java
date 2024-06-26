package com.alinesno.infra.ops.logback.entity.app;

import com.alinesno.infra.ops.logback.entity.BaseLogEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通用业务日志记录实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("business_log")
@Data
public class BusinessLogEntity extends BaseLogEntity {

    @TableField("log_level")
    @ColumnType(length = 20)
    @ColumnComment("日志级别")
    private String logLevel;

    @TableField("log_content")
    @ColumnType(length = 255)
    @ColumnComment("日志内容")
    private String logContent;

    @TableField("log_time")
    @ColumnType(length = 19)
    @ColumnComment("日志时间")
    private long logTime;

    @TableField("log_class")
    @ColumnType(length = 100)
    @ColumnComment("日志类路径")
    private String logClass;

    @TableField("log_thread")
    @ColumnType(length = 50)
    @ColumnComment("日志线程")
    private String logThread;

    @TableField("track_id")
    @ColumnType(length = 50)
    @ColumnComment("全局跟踪ID")
    private String trackId;
}
