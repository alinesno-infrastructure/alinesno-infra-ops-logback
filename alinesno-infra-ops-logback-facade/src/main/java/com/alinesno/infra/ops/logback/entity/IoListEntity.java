package com.alinesno.infra.ops.logback.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * IO信息实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("io_list")
public class IoListEntity extends InfraBaseEntity {

    // URL名称
    @TableField("name")
    private String name;

    // IO类型
    @TableField("entry_type")
    private String entryType;

    // 开始时间
    @TableField("start_time")
    private double startTime;

    // 持续时间
    @TableField("duration")
    private double duration;

    // 初始化类型
    @TableField("initiator_type")
    private String initiatorType;

    // 下一跳协议
    @TableField("next_hop_protocol")
    private String nextHopProtocol;

    // 渲染阻塞状态
    @TableField("render_blocking_status")
    private String renderBlockingStatus;

    // Worker开始时间
    @TableField("worker_start")
    private double workerStart;

    // 重定向开始时间
    @TableField("redirect_start")
    private double redirectStart;

    // 重定向结束时间
    @TableField("redirect_end")
    private double redirectEnd;

    // 获取开始时间
    @TableField("fetch_start")
    private double fetchStart;

    // 域名查询开始时间
    @TableField("domain_lookup_start")
    private double domainLookupStart;

    // 域名查询结束时间
    @TableField("domain_lookup_end")
    private double domainLookupEnd;

    // 连接开始时间
    @TableField("connect_start")
    private double connectStart;

    // 连接结束时间
    @TableField("connect_end")
    private double connectEnd;

    // 安全连接开始时间
    @TableField("secure_connection_start")
    private double secureConnectionStart;

    // 请求开始时间
    @TableField("request_start")
    private double requestStart;

    // 响应开始时间
    @TableField("response_start")
    private double responseStart;

    // 响应结束时间
    @TableField("response_end")
    private double responseEnd;

    // 传输大小
    @TableField("transfer_size")
    private int transferSize;

    // 编码后的主体大小
    @TableField("encoded_body_size")
    private int encodedBodySize;

    // 解码后的主体大小
    @TableField("decoded_body_size")
    private int decodedBodySize;

    // 服务器计时信息
    @TableField("server_timing")
    private String serverTiming;

    // 卸载事件开始时间
    @TableField("unload_event_start")
    private double unloadEventStart;

    // 卸载事件结束时间
    @TableField("unload_event_end")
    private double unloadEventEnd;

    // DOM可交互时间
    @TableField("dom_interactive")
    private double domInteractive;

    // DOM内容加载事件开始时间
    @TableField("dom_content_loaded_event_start")
    private double domContentLoadedEventStart;

    // DOM内容加载事件结束时间
    @TableField("dom_content_loaded_event_end")
    private double domContentLoadedEventEnd;

    // DOM完成时间
    @TableField("dom_complete")
    private double domComplete;

    // 页面加载事件开始时间
    @TableField("load_event_start")
    private double loadEventStart;

    // 页面加载事件结束时间
    @TableField("load_event_end")
    private double loadEventEnd;

    // 类型
    @TableField("type")
    private String type;

    // 重定向次数
    @TableField("redirect_count")
    private int redirectCount;

    // 激活开始时间
    @TableField("activation_start")
    private double activationStart;

    // 日志类型
    @TableField("log_type")
    private String logType;

    // 时间步长
    @TableField("time_step")
    private long timeStep;

    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getInitiatorType() {
        return initiatorType;
    }

    public void setInitiatorType(String initiatorType) {
        this.initiatorType = initiatorType;
    }

    public String getNextHopProtocol() {
        return nextHopProtocol;
    }

    public void setNextHopProtocol(String nextHopProtocol) {
        this.nextHopProtocol = nextHopProtocol;
    }

    public String getRenderBlockingStatus() {
        return renderBlockingStatus;
    }

    public void setRenderBlockingStatus(String renderBlockingStatus) {
        this.renderBlockingStatus = renderBlockingStatus;
    }

    public double getWorkerStart() {
        return workerStart;
    }

    public void setWorkerStart(double workerStart) {
        this.workerStart = workerStart;
    }

    public double getRedirectStart() {
        return redirectStart;
    }

    public void setRedirectStart(double redirectStart) {
        this.redirectStart = redirectStart;
    }

    public double getRedirectEnd() {
        return redirectEnd;
    }

    public void setRedirectEnd(double redirectEnd) {
        this.redirectEnd = redirectEnd;
    }

    public double getFetchStart() {
        return fetchStart;
    }

    public void setFetchStart(double fetchStart) {
        this.fetchStart = fetchStart;
    }

    public double getDomainLookupStart() {
        return domainLookupStart;
    }

    public void setDomainLookupStart(double domainLookupStart) {
        this.domainLookupStart = domainLookupStart;
    }

    public double getDomainLookupEnd() {
        return domainLookupEnd;
    }

    public void setDomainLookupEnd(double domainLookupEnd) {
        this.domainLookupEnd = domainLookupEnd;
    }

    public double getConnectStart() {
        return connectStart;
    }

    public void setConnectStart(double connectStart) {
        this.connectStart = connectStart;
    }

    public double getConnectEnd() {
        return connectEnd;
    }

    public void setConnectEnd(double connectEnd) {
        this.connectEnd = connectEnd;
    }

    public double getSecureConnectionStart() {
        return secureConnectionStart;
    }

    public void setSecureConnectionStart(double secureConnectionStart) {
        this.secureConnectionStart = secureConnectionStart;
    }

    public double getRequestStart() {
        return requestStart;
    }

    public void setRequestStart(double requestStart) {
        this.requestStart = requestStart;
    }

    public double getResponseStart() {
        return responseStart;
    }

    public void setResponseStart(double responseStart) {
        this.responseStart = responseStart;
    }

    public double getResponseEnd() {
        return responseEnd;
    }

    public void setResponseEnd(double responseEnd) {
        this.responseEnd = responseEnd;
    }

    public int getTransferSize() {
        return transferSize;
    }

    public void setTransferSize(int transferSize) {
        this.transferSize = transferSize;
    }

    public int getEncodedBodySize() {
        return encodedBodySize;
    }

    public void setEncodedBodySize(int encodedBodySize) {
        this.encodedBodySize = encodedBodySize;
    }

    public int getDecodedBodySize() {
        return decodedBodySize;
    }

    public void setDecodedBodySize(int decodedBodySize) {
        this.decodedBodySize = decodedBodySize;
    }

    public String getServerTiming() {
        return serverTiming;
    }

    public void setServerTiming(String serverTiming) {
        this.serverTiming = serverTiming;
    }

    public double getUnloadEventStart() {
        return unloadEventStart;
    }

    public void setUnloadEventStart(double unloadEventStart) {
        this.unloadEventStart = unloadEventStart;
    }

    public double getUnloadEventEnd() {
        return unloadEventEnd;
    }

    public void setUnloadEventEnd(double unloadEventEnd) {
        this.unloadEventEnd = unloadEventEnd;
    }

    public double getDomInteractive() {
        return domInteractive;
    }

    public void setDomInteractive(double domInteractive) {
        this.domInteractive = domInteractive;
    }

    public double getDomContentLoadedEventStart() {
        return domContentLoadedEventStart;
    }

    public void setDomContentLoadedEventStart(double domContentLoadedEventStart) {
        this.domContentLoadedEventStart = domContentLoadedEventStart;
    }

    public double getDomContentLoadedEventEnd() {
        return domContentLoadedEventEnd;
    }

    public void setDomContentLoadedEventEnd(double domContentLoadedEventEnd) {
        this.domContentLoadedEventEnd = domContentLoadedEventEnd;
    }

    public double getDomComplete() {
        return domComplete;
    }

    public void setDomComplete(double domComplete) {
        this.domComplete = domComplete;
    }

    public double getLoadEventStart() {
        return loadEventStart;
    }

    public void setLoadEventStart(double loadEventStart) {
        this.loadEventStart = loadEventStart;
    }

    public double getLoadEventEnd() {
        return loadEventEnd;
    }

    public void setLoadEventEnd(double loadEventEnd) {
        this.loadEventEnd = loadEventEnd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRedirectCount() {
        return redirectCount;
    }

    public void setRedirectCount(int redirectCount) {
        this.redirectCount = redirectCount;
    }

    public double getActivationStart() {
        return activationStart;
    }

    public void setActivationStart(double activationStart) {
        this.activationStart = activationStart;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public long getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(long timeStep) {
        this.timeStep = timeStep;
    }
}