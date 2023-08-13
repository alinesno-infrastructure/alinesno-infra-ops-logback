package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.LoginRecordEntity;
import com.alinesno.infra.ops.logback.mapper.LoginRecordMapper;
import com.alinesno.infra.ops.logback.service.ILoginRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 用户登陆记录表Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Service
public class LoginRecordServiceImpl extends IBaseServiceImpl<LoginRecordEntity, LoginRecordMapper> implements ILoginRecordService {
    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(LoginRecordServiceImpl.class);
}
