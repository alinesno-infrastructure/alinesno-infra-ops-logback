package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.page.TerminalInfoEntity;
import com.alinesno.infra.ops.logback.mapper.TerminalInfoMapper;
import com.alinesno.infra.ops.logback.service.page.ITerminalInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 终端信息Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class TerminalInfoServiceImpl extends IBaseServiceImpl<TerminalInfoEntity, TerminalInfoMapper> implements ITerminalInfoService {
    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(TerminalInfoServiceImpl.class);
}
