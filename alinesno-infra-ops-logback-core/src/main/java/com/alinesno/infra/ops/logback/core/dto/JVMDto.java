package com.alinesno.infra.ops.logback.core.dto;

/**
 * JVMDto类表示JVM相关信息的数据传输对象。
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
public class JVMDto {

    private String jvmTotalMemory; // JVM总内存
    private String jvmUsedMemory; // JVM已使用内存
    private String jvmRemainingMemory; // JVM剩余内存
    private double jvmMemoryUsage; // JVM内存使用率
    private String javaVersion; // Java版本
    private String jarList; // Jar列表
    private String javaRuntime; // Java运行时环境

    // Getters and setters

    public String getJvmTotalMemory() {
        return jvmTotalMemory;
    }

    public void setJvmTotalMemory(String jvmTotalMemory) {
        this.jvmTotalMemory = jvmTotalMemory;
    }

    public String getJvmUsedMemory() {
        return jvmUsedMemory;
    }

    public void setJvmUsedMemory(String jvmUsedMemory) {
        this.jvmUsedMemory = jvmUsedMemory;
    }

    public String getJvmRemainingMemory() {
        return jvmRemainingMemory;
    }

    public void setJvmRemainingMemory(String jvmRemainingMemory) {
        this.jvmRemainingMemory = jvmRemainingMemory;
    }

    public double getJvmMemoryUsage() {
        return jvmMemoryUsage;
    }

    public void setJvmMemoryUsage(double jvmMemoryUsage) {
        this.jvmMemoryUsage = jvmMemoryUsage;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getJarList() {
        return jarList;
    }

    public void setJarList(String jarList) {
        this.jarList = jarList;
    }

    public String getJavaRuntime() {
        return javaRuntime;
    }

    public void setJavaRuntime(String javaRuntime) {
        this.javaRuntime = javaRuntime;
    }
}