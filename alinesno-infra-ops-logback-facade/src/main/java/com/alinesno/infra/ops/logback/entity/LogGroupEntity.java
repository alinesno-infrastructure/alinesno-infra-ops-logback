package com.alinesno.infra.ops.logback.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 日志分组管理实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("log_group")
@Data
public class LogGroupEntity extends InfraBaseEntity {

    // 类型ID
    @TableField("type_id")
	@ColumnType(length=255)
	@ColumnComment("类型ID")
    private String typeId;

    // 类型名称
    @TableField("type_name")
	@ColumnType(length=50)
	@ColumnComment("类型名称")
    private String typeName;

    // 描述
    @TableField("description")
	@ColumnType(length=255)
	@ColumnComment("描述")
    private String description;
}
