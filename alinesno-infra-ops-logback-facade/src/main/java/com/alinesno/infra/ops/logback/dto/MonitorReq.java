package com.alinesno.infra.ops.logback.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description 接口监控请求参数封装
 * @author JL
 * @date 2021/04/14
 * @version v1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MonitorReq extends BaseReq {
    private String status;
}
