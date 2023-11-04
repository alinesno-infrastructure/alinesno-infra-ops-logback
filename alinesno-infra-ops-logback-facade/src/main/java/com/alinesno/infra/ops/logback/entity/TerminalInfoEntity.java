package com.alinesno.infra.ops.logback.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 终端信息实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("terminal_info")
@Data
public class TerminalInfoEntity extends InfraBaseEntity {

    // 宽高比
    @TableField("resolving_power")
	@ColumnType(length=10)
	@ColumnComment("宽高比")
    private String resolvingPower;

    // 引荐来源
    @TableField("referrer")
	@ColumnType(length=255)
	@ColumnComment("引荐来源")
    private String referrer;

    // 用户代理
    @TableField("ua")
	@ColumnType(length=255)
	@ColumnComment("用户代理")
    private String ua;

    // 浏览器信息
    @TableField("browser_name")
	@ColumnType(length=50)
	@ColumnComment("浏览器信息")
    private String browserName;

    @TableField("browser_version")
	@ColumnType(length=10)
	@ColumnComment("浏览器版本")
    private String browserVersion;

    @TableField("browser_major")
	@ColumnType(length=2)
	@ColumnComment("浏览器主版本")
    private String browserMajor;

    // 引擎信息
    @TableField("engine_name")
	@ColumnType(length=50)
	@ColumnComment("引擎信息")
    private String engineName;

    @TableField("engine_version")
	@ColumnType(length=10)
	@ColumnComment("引擎版本")
    private String engineVersion;

    // 系统信息
    @TableField("os_name")
	@ColumnType(length=50)
	@ColumnComment("系统信息")
    private String osName;

    @TableField("os_version")
	@ColumnType(length=50)
	@ColumnComment("操作系统版本")
    private String osVersion;

    // IP地址
    @TableField("ip")
	@ColumnType(length=15)
	@ColumnComment("IP地址")
    private String ip;

    // 城市
    @TableField("city")
	@ColumnType(length=50)
	@ColumnComment("城市")
    private String city;
}
