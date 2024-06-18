package com.alinesno.infra.ops.logback.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

/**
 * className：RunLogMessage
 * description：
 * time：2020-05-11.16:17
 *
 * @author Tank
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RunLogMessage extends BaseLogMessage {

    private Long dtTime;
    private String content;
    private String logLevel;
    private String className;
    private String threadName;
    private String logType;
    private String dateTime;
    /**
     * 当dtTime相同时服务端无法正确排序，因此需要增加一个字段保证相同毫秒的日志可正确排序
     */
    private Long seq;

    private Map<String, String> MDCPropertyMap;
    private Map<String, String> MDC;
    private long timeStamp ;
    private int nanoseconds;

    /**
     * 运行时信息
     */
    private JVMDto jvm ;
    private DiskInfo disk ;
    private CPUDto cpu ;
    private MemDto mem ;
    private OsDto os ;
    private List<ThreadDto> threadDtos ;

}
