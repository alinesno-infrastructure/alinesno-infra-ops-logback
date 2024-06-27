package com.alinesno.infra.ops.logback.entity.channel;

import com.alinesno.infra.ops.logback.entity.BaseLogEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Kubernetes Audit事件
 */
@EqualsAndHashCode(callSuper = true)
@TableName("kubernetes_log") // 指定数据库表名
@Data
public class KubernetesLogEntity extends BaseLogEntity {

}
