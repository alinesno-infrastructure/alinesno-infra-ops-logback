package com.alinesno.infra.ops.logback.core.dto;

/**
 * CPUDto类表示CPU相关信息的数据传输对象。
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
public class CPUDto {
    private int cpuCores; // CPU核心数
    private double cpuSystemUsage; // CPU系统使用率
    private double cpuUserUsage; // CPU用户使用率
    private double cpuWaitRate; // CPU等待率
    private double cpuCurrentUsage; // 当前CPU使用率

    // Getters and setters

    public int getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public double getCpuSystemUsage() {
        return cpuSystemUsage;
    }

    public void setCpuSystemUsage(double cpuSystemUsage) {
        this.cpuSystemUsage = cpuSystemUsage;
    }

    public double getCpuUserUsage() {
        return cpuUserUsage;
    }

    public void setCpuUserUsage(double cpuUserUsage) {
        this.cpuUserUsage = cpuUserUsage;
    }

    public double getCpuWaitRate() {
        return cpuWaitRate;
    }

    public void setCpuWaitRate(double cpuWaitRate) {
        this.cpuWaitRate = cpuWaitRate;
    }

    public double getCpuCurrentUsage() {
        return cpuCurrentUsage;
    }

    public void setCpuCurrentUsage(double cpuCurrentUsage) {
        this.cpuCurrentUsage = cpuCurrentUsage;
    }
}
