package com.alinesno.infra.ops.logback.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 日志类型管理实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("log_type")
public class LogTypeEntity extends InfraBaseEntity {

    // 类型ID
    @TableField("TypeID")
    private String typeId;

    // 类型名称
    @TableField("TypeName")
    private String typeName;

    // 描述
    @TableField("Description")
    private String description;

    // Getters and Setters

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}