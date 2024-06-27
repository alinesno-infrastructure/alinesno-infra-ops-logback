package com.alinesno.infra.ops.logback.service.impl.channel;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.channel.KubernetesLogEntity;
import com.alinesno.infra.ops.logback.mapper.KubernetesLogMapper;
import com.alinesno.infra.ops.logback.service.channel.IKubernetesLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KubernetesLogServiceImpl extends IBaseServiceImpl<KubernetesLogEntity, KubernetesLogMapper> implements IKubernetesLogService {
}
