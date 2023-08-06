package com.alinesno.infra.ops.logback.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 失败消息实体
 * @author luoxiaodong
 * @since 1.0.0
 */
@TableName("notice_fail") // 指定数据库表名
public class FailEntity extends NoticeSendBaseEntity {
}