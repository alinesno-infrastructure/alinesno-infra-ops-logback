package com.alinesno.infra.ops.logback.api.provider;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 采集前端日志服务
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@RequestMapping("/v1/api/collector")
@RestController
public class CollectorPageController {

    @Value("${alinesno.ops.logback.model:redis}")
    private String model ;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

     @PostMapping("/pageLog")
    public AjaxResult databaseLog(@RequestBody String message){
        sendRedisQueue(message);
        return AjaxResult.success(model) ;
    }

    /**
     * 将消息发送到Redis流中。
     * <p>
     * 此方法用于将给定的消息封装到一个Map中，并通过Redis流将其发送出去。
     * 使用Redis流可以实现消息的可靠传输和存储，适用于消息队列或事件驱动架构。
     *
     * @param message 消息内容，作为流中的值。
     */
    private void sendRedisQueue(String message) {
        // 使用DEBUG级别日志记录消息内容，用于调试和日志记录。
        log.debug("businessLog logRest message = {}" , message);

        // 创建一个Map来存储消息，其中key为消息键，message为消息值。
        Map<String, String> messageMap = new HashMap<>();
        messageMap.put(MessageConstant.REDIS_REST_PAGE_KEY, message);

        // 将消息添加到Redis流中，返回记录的ID。
        RecordId recordId = redisTemplate.opsForStream().add(MessageConstant.REDIS_REST_PAGE_KEY, messageMap);
        // 使用INFO级别日志记录消息发送的成功事件和记录ID，用于监控和日志记录。
        if (recordId != null) {
            log.info(MessageConstant.REDIS_REST_PAGE_KEY + " Message sent to Stream topic:{} with RecordId:{}"  , MessageConstant.REDIS_REST_PAGE_KEY, recordId);
        }
    }

}
