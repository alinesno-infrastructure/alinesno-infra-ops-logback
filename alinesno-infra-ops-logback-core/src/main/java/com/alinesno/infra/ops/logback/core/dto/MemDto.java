package com.alinesno.infra.ops.logback.core.dto;

/**
 * MenDto类表示内存相关信息的数据传输对象。
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
public class MemDto {
    private String totalMemory; // 总内存
    private String usedMemory; // 已使用内存
    private String remainingMemory; // 剩余内存
    private double memoryUsage; // 内存使用率

    // Getters and setters

    public String getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(String totalMemory) {
        this.totalMemory = totalMemory;
    }

    public String getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(String usedMemory) {
        this.usedMemory = usedMemory;
    }

    public String getRemainingMemory() {
        return remainingMemory;
    }

    public void setRemainingMemory(String remainingMemory) {
        this.remainingMemory = remainingMemory;
    }

    public double getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(double memoryUsage) {
        this.memoryUsage = memoryUsage;
    }
}

