package com.alinesno.infra.ops.logback.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * IO信息实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("io_list")
public class IoListEntity {

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
}