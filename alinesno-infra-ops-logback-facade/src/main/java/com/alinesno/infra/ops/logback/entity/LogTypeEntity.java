package com.alinesno.infra.ops.logback.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 日志类型管理实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("log_type")
@Data
public class LogTypeEntity extends InfraBaseEntity {

    // 类型ID
    @TableField("TypeID")
	@ColumnType(length=255)
	@ColumnComment("类型ID")
    private String typeId;

    // 类型名称
    @TableField("TypeName")
	@ColumnType(length=50)
	@ColumnComment("类型名称")
    private String typeName;

    // 描述
    @TableField("Description")
	@ColumnType(length=255)
	@ColumnComment("描述")
    private String description;
}
