package com.alinesno.infra.ops.logback.adapter.handle;

import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import com.alinesno.infra.ops.logback.entity.app.BusinessLogEntity;
import com.alinesno.infra.ops.logback.service.app.IBusinessLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 处理业务日志消息
 */
@Slf4j
@Component(MessageConstant.REDIS_REST_BUSINESS_KEY)
public class BusinessLogHandle implements BaseHandle {

    @Autowired
    private IBusinessLogService businessLogService ;

    @Override
    public void analyseMessage(String message) {
        log.debug("-->> BusinessLogHandle message = {}" , message);
        JSONObject jsonObject = JSONObject.parseObject(message);

        BusinessLogEntity businessLog = new BusinessLogEntity() ;

        businessLog.setLogLevel(jsonObject.getString("level"));
        businessLog.setLogContent(jsonObject.getString("description"));
        businessLog.setLogTime(jsonObject.getLong("timestamp"));

        businessLogService.save(businessLog) ;
    }

}
