package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.IoListEntity;
import com.alinesno.infra.ops.logback.mapper.IoListMapper;
import com.alinesno.infra.ops.logback.service.IIoListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * IO信息Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class IoListServiceImpl extends IBaseServiceImpl<IoListEntity, IoListMapper> implements IIoListService {
    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(IoListServiceImpl.class);
}
