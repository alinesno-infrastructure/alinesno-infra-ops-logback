package com.alinesno.infra.ops.logback.core.bus;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 该类表示一个监控消息，用于封装异常或监控事件的相关信息。
 */
@NoArgsConstructor
@Data
public class MsgDto {

    /**
     * 异常或事件的描述信息。
     */
    private String description;

    /**
     * 异常的错误信息，通常为异常堆栈的简要描述。
     */
    private String errorMsg;

    /**
     * 异常或事件的分类，用于对问题进行初步归类。
     */
    private String category; // 预警信息分类

    /**
     * 项目的唯一标识码。
     */
    private String projectCode ;

    /**
     * 异常或事件的等级，用于区分不同严重程度的问题。
     * 默认为重要等级。
     */
    private String level = AlertLevelEnum.IMPORTANT.getCode() ;


    /**
     * 异常或事件发生的时间戳。
     */
    private long timestamp;

    /**
     * 异常上下文信息，用于提供问题发生的上下文环境，如相关的请求ID等。
     */
    private String context;

    /**
     * 环境信息，用于描述问题发生的环境，如生产环境、测试环境等。
     */
    private String envInfo;

    /**
     * 构造函数，用于创建一个包含描述、错误信息和等级的监控消息。
     *
     * @param description 异常或事件的描述。
     * @param errorMsg 异常的错误信息。
     * @param level 异常或事件的等级。
     */
    public MsgDto(String description, String errorMsg, String level) {
        this.description = description;
        this.errorMsg = errorMsg;
        this.level = level;
    }

    /**
     * 构造函数，用于创建一个包含描述和等级的监控消息。
     *
     * @param description 异常或事件的描述。
     * @param level 异常或事件的等级。
     */
    public MsgDto(String description, String level) {
        this.description = description;
        this.level = level;
    }
}

