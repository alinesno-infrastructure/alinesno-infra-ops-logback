package com.alinesno.infra.ops.logback.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 性能信息实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("performance_info")
public class PerformanceInfoEntity extends InfraBaseEntity {

    // 首次内容绘制 (FCP)
    @TableField("fcp")
    private double fcp;

    // 白屏时间（FP）
    @TableField("fp")
    private int fp;

    // 重定向耗时
    @TableField("redirect_time")
    private int redirectTime;

    // DNS查询耗时
    @TableField("domain_lookup_time")
    private int domainLookupTime;

    // TCP链接耗时
    @TableField("connect_time")
    private int connectTime;

    // HTTP请求耗时
    @TableField("response_time")
    private int responseTime;

    // DOM解析耗时
    @TableField("dom_complete_time")
    private int domCompleteTime;

    // 第一字节时间 (TTFB)
    @TableField("ttfb")
    private double ttfb;

    // Getters and Setters

    public double getFcp() {
        return fcp;
    }

    public void setFcp(double fcp) {
        this.fcp = fcp;
    }

    public int getFp() {
        return fp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }

    public int getRedirectTime() {
        return redirectTime;
    }

    public void setRedirectTime(int redirectTime) {
        this.redirectTime = redirectTime;
    }

    public int getDomainLookupTime() {
        return domainLookupTime;
    }

    public void setDomainLookupTime(int domainLookupTime) {
        this.domainLookupTime = domainLookupTime;
    }

    public int getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(int connectTime) {
        this.connectTime = connectTime;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public int getDomCompleteTime() {
        return domCompleteTime;
    }

    public void setDomCompleteTime(int domCompleteTime) {
        this.domCompleteTime = domCompleteTime;
    }

    public double getTtfb() {
        return ttfb;
    }

    public void setTtfb(double ttfb) {
        this.ttfb = ttfb;
    }
}