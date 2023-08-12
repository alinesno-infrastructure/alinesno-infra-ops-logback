package com.alinesno.infra.ops.logback.core.dto;

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

    public List<ThreadDto> getThreadDtos() {
        return threadDtos;
    }

    public void setThreadDtos(List<ThreadDto> threadDtos) {
        this.threadDtos = threadDtos;
    }

    public Long getDtTime() {
        return dtTime;
    }

    public void setDtTime(Long dtTime) {
        this.dtTime = dtTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Map<String, String> getMDCPropertyMap() {
        return MDCPropertyMap;
    }

    public void setMDCPropertyMap(Map<String, String> MDCPropertyMap) {
        this.MDCPropertyMap = MDCPropertyMap;
    }

    public Map<String, String> getMDC() {
        return MDC;
    }

    public void setMDC(Map<String, String> MDC) {
        this.MDC = MDC;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getNanoseconds() {
        return nanoseconds;
    }

    public void setNanoseconds(int nanoseconds) {
        this.nanoseconds = nanoseconds;
    }

    public JVMDto getJvm() {
        return jvm;
    }

    public void setJvm(JVMDto jvm) {
        this.jvm = jvm;
    }

    public DiskInfo getDisk() {
        return disk;
    }

    public void setDisk(DiskInfo disk) {
        this.disk = disk;
    }

    public CPUDto getCpu() {
        return cpu;
    }

    public void setCpu(CPUDto cpu) {
        this.cpu = cpu;
    }

    public MemDto getMem() {
        return mem;
    }

    public void setMem(MemDto mem) {
        this.mem = mem;
    }

    public OsDto getOs() {
        return os;
    }

    public void setOs(OsDto os) {
        this.os = os;
    }
}
