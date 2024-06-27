package com.alinesno.infra.ops.logback.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.ops.logback.entity.AccountRecordEntity;
import com.alinesno.infra.ops.logback.mapper.AccountRecordMapper;
import com.alinesno.infra.ops.logback.service.IAccountRecordService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 用户操作记录Service业务层处理
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Slf4j
@Service
public class AccountRecordServiceImpl extends IBaseServiceImpl<AccountRecordEntity, AccountRecordMapper> implements IAccountRecordService {
}
