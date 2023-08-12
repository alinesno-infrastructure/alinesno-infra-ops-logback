package com.alinesno.infra.ops.logback.core.dto;

/**
 * ThreadDto类表示线程相关信息的数据传输对象。
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
public class ThreadDto {
    private String threadData; // 线程数据
    private int threadId; // 线程ID
    private String threadName; // 线程名称
    private String threadStatus; // 线程状态
    private String memoryOccupied; // 占用内存

    // Getters and setters

    public String getThreadData() {
        return threadData;
    }

    public void setThreadData(String threadData) {
        this.threadData = threadData;
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadStatus() {
        return threadStatus;
    }

    public void setThreadStatus(String threadStatus) {
        this.threadStatus = threadStatus;
    }

    public String getMemoryOccupied() {
        return memoryOccupied;
    }

    public void setMemoryOccupied(String memoryOccupied) {
        this.memoryOccupied = memoryOccupied;
    }
}