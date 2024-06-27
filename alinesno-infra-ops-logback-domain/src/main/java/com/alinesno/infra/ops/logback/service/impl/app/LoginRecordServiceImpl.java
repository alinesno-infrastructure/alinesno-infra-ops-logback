package com.alinesno.infra.ops.logback.service.impl.app;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.app.LoginLogEntity;
import com.alinesno.infra.ops.logback.mapper.LoginLogMapper;
import com.alinesno.infra.ops.logback.service.app.ILoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户登陆记录表Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Slf4j
@Service
public class LoginRecordServiceImpl extends IBaseServiceImpl<LoginLogEntity, LoginLogMapper> implements ILoginLogService {

}
