package com.alinesno.infra.ops.logback.service.impl.page;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.page.TerminalEntity;
import com.alinesno.infra.ops.logback.mapper.TerminalMapper;
import com.alinesno.infra.ops.logback.service.page.ITerminalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 终端信息Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Slf4j
@Service
public class TerminalServiceImpl extends IBaseServiceImpl<TerminalEntity, TerminalMapper> implements ITerminalService {

}
