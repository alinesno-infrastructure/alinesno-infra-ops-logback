package com.alinesno.infra.ops.logback.entity.page;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 性能信息实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("performance_info")
@Data
public class PerformanceEntity extends PageEntity {

    // 首次内容绘制 (FCP)
    @TableField("fcp")
	@ColumnType(length=255)
	@ColumnComment("首次内容绘制")
    private double fcp;

    // 白屏时间（FP）
    @TableField("fp")
	@ColumnType(length=255)
	@ColumnComment("白屏时间（FP）")
    private int fp;

    // 重定向耗时
    @TableField("redirect_time")
	@ColumnType(length=10)
	@ColumnComment("重定向耗时")
    private int redirectTime;

    // DNS查询耗时
    @TableField("domain_lookup_time")
	@ColumnType(length=10)
	@ColumnComment("DNS查询耗时")
    private int domainLookupTime;

    // TCP链接耗时
    @TableField("connect_time")
	@ColumnType(length=255)
	@ColumnComment("TCP链接耗时")
    private int connectTime;

    // HTTP请求耗时
    @TableField("response_time")
	@ColumnType(length=255)
	@ColumnComment("HTTP请求耗时")
    private int responseTime;

    // DOM解析耗时
    @TableField("dom_complete_time")
	@ColumnType(length=255)
	@ColumnComment("DOM解析耗时")
    private int domCompleteTime;

    // 第一字节时间 (TTFB)
    @TableField("ttfb")
	@ColumnType(length=255)
	@ColumnComment("第一字节时间")
    private double ttfb;
}
