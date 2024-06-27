package com.alinesno.infra.ops.logback.service.impl.page;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.page.IoEntity;
import com.alinesno.infra.ops.logback.mapper.IoMapper;
import com.alinesno.infra.ops.logback.service.page.IIoService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * IO信息Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Slf4j
@Service
public class IoServiceImpl extends IBaseServiceImpl<IoEntity, IoMapper> implements IIoService {

}
