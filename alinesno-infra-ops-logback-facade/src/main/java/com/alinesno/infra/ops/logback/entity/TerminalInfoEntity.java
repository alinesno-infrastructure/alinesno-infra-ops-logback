package com.alinesno.infra.ops.logback.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 终端信息实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("terminal_info")
public class TerminalInfoEntity {

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
}
