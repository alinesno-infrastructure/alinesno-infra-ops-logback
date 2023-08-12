package com.alinesno.infra.ops.logback.core.dto;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * OsDto类表示操作系统相关信息的数据传输对象。
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
public class OsDto {

    private String operatingSystemName; // 操作系统名称
    private String systemArchitecture; // 系统架构
    private String cpu; // CPU信息
    private List<DiskInfo> disk; // 磁盘信息
    private String memory; // 内存信息

    // Getters and setters

    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    public void setOperatingSystemName(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    public String getSystemArchitecture() {
        return systemArchitecture;
    }

    public void setSystemArchitecture(String systemArchitecture) {
        this.systemArchitecture = systemArchitecture;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public List<DiskInfo> getDisk() {
        return disk;
    }

    public void setDisk(List<DiskInfo> disk) {
        this.disk = disk;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

}