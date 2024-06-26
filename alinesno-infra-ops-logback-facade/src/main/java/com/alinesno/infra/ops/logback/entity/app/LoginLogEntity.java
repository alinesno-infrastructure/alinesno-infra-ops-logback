package com.alinesno.infra.ops.logback.entity.app;

import com.alinesno.infra.ops.logback.entity.BaseLogEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户登陆记录表
 * </p>
 *
 * @author luoxiaodong
 * @version 1.0.0
 */

@EqualsAndHashCode(callSuper = true)
@TableName("manager_login_log")
@Data
public class LoginLogEntity extends BaseLogEntity {

	/**
	 * 登陆名
	 */
	@Excel(name = "登陆名")
	@TableField("login_name")
	@ColumnType(length=50)
	@ColumnComment("登陆名")
	private String loginName;

	/**
	 * 登陆时间
	 */
	@Excel(name = "登陆时间", format = "yyyy-MM-dd HH:mm:ss")
	@TableField("login_time")
	@JSONField(format = "yyyy-MM-dd")
	@ColumnType(length=19)
	@ColumnComment("登陆时间")
	private Date loginTime;
	/**
	 * 登陆IP
	 */
	@Excel(name = "登陆IP")
	@TableField("login_ip")
	@ColumnType(length=15)
	@ColumnComment("登陆IP")
	private String loginIp;
	/**
	 * 登陆状态(1成功|0失败)
	 */
	@Excel(name = "登陆状态", replace = { "成功_1", "失败_0", "_null" })
	@TableField("login_status")
	@ColumnType(length=255)
	@ColumnComment("登陆状态(1成功|0失败)")
	private String loginStatus;
	/**
	 * 错误密码
	 */
	@Excel(name = "错误密码")
	@TableField("error_password")
	@ColumnType(length=255)
	@ColumnComment("错误密码")
	private String errorPassword;
	/**
	 * 手机验证码
	 */
	@Excel(name = "手机验证码")
	@TableField("phone_code")
	@ColumnType(length=4)
	@ColumnComment("手机验证码")
	private String phoneCode;
	/**
	 * 邮箱验证码
	 */
	@Excel(name = "邮箱验证码")
	@TableField("email_code")
	@ColumnType(length=6)
	@ColumnComment("邮箱验证码")
	private String emailCode;
	/**
	 * 登陆来源
	 */
	@Excel(name = "登陆来源")
	@TableField("login_src")
	@ColumnType(length=50)
	@ColumnComment("登陆来源")
	private String loginSrc;
	/**
	 * 退出时间
	 */
	@Excel(name = "退出时间", format = "yyyy-MM-dd HH:mm:ss")
	@TableField("sign_out_time")
	@JSONField(format = "yyyy-MM-dd")
	@ColumnType(length=8)
	@ColumnComment("退出时间")
	private Date signOutTime;
	/**
	 * 浏览器信息
	 */
	@Excel(name = "浏览器信息")
	@TableField("login_browser")
	@ColumnType(length=255)
	@ColumnComment("浏览器信息")
	private String loginBrowser;
	/**
	 * 登陆备注
	 */
	@Excel(name = "登陆备注")
	@TableField("login_remark")
	@ColumnType(length=255)
	@ColumnComment("登陆备注")
	private String loginRemark;
}
