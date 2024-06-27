package com.alinesno.infra.ops.logback.entity.page;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageEntity extends InfraBaseEntity {

    private String uid ; //user标识，由ip与ua生成，用以追溯行为轨迹
    private String pageId ; //配置信息中的id标识将携带在每条报文中

}
