package com.alinesno.infra.ops.logback.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 终端信息实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("terminal_info")
public class TerminalInfoEntity extends InfraBaseEntity {

    // 宽高比
    @TableField("resolving_power")
    private String resolvingPower;

    // 引荐来源
    @TableField("referrer")
    private String referrer;

    // 用户代理
    @TableField("ua")
    private String ua;

    // 浏览器信息
    @TableField("browser_name")
    private String browserName;

    @TableField("browser_version")
    private String browserVersion;

    @TableField("browser_major")
    private String browserMajor;

    // 引擎信息
    @TableField("engine_name")
    private String engineName;

    @TableField("engine_version")
    private String engineVersion;

    // 系统信息
    @TableField("os_name")
    private String osName;

    @TableField("os_version")
    private String osVersion;

    // IP地址
    @TableField("ip")
    private String ip;

    // 城市
    @TableField("city")
    private String city;

    // Getters and Setters

    public String getResolvingPower() {
        return resolvingPower;
    }

    public void setResolvingPower(String resolvingPower) {
        this.resolvingPower = resolvingPower;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getBrowserMajor() {
        return browserMajor;
    }

    public void setBrowserMajor(String browserMajor) {
        this.browserMajor = browserMajor;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
