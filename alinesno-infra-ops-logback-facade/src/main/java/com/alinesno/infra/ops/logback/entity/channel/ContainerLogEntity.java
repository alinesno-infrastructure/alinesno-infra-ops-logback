package com.alinesno.infra.ops.logback.entity.channel;

import com.alinesno.infra.ops.logback.entity.BaseLogEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 容器日志服务
 */
@EqualsAndHashCode(callSuper = true)
@TableName("container_log")
@Data
public class ContainerLogEntity extends BaseLogEntity {

}
