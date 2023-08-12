package com.alinesno.infra.ops.logback.core.dto;

public class DiskInfo {

    private String driver;
    private String total;
    private String usage;
    private double percentUsage;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public double getPercentUsage() {
        return percentUsage;
    }

    public void setPercentUsage(double percentUsage) {
        this.percentUsage = percentUsage;
    }
}