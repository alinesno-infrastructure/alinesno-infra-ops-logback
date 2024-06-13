package com.alinesno.infra.ops.logback.entity.page;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * IO信息实体类
 * @author luoxiaodong
 * @version 1.0.0
 */
@TableName("io_list")
@Data
public class IoListEntity extends InfraBaseEntity {

    // URL名称
    @TableField("name")
	@ColumnType(length=255)
	@ColumnComment("URL名称")
    private String name;

    // IO类型
    @TableField("entry_type")
	@ColumnType(length=20)
	@ColumnComment("IO类型")
    private String entryType;

    // 开始时间
    @TableField("start_time")
	@ColumnType(length=19)
	@ColumnComment("开始时间")
    private double startTime;

    // 持续时间
    @TableField("duration")
	@ColumnType(length=8)
	@ColumnComment("持续时间")
    private double duration;

    // 初始化类型
    @TableField("initiator_type")
	@ColumnType(length=10)
	@ColumnComment("初始化类型")
    private String initiatorType;

    // 下一跳协议
    @TableField("next_hop_protocol")
	@ColumnType(length=20)
	@ColumnComment("下一跳协议")
    private String nextHopProtocol;

    // 渲染阻塞状态
    @TableField("render_blocking_status")
	@ColumnType(length=1)
	@ColumnComment("渲染阻塞状态")
    private String renderBlockingStatus;

    // Worker开始时间
    @TableField("worker_start")
	@ColumnType(length=20)
	@ColumnComment("Worker开始时间")
    private double workerStart;

    // 重定向开始时间
    @TableField("redirect_start")
	@ColumnType(length=2)
	@ColumnComment("重定向开始时间")
    private double redirectStart;

    // 重定向结束时间
    @TableField("redirect_end")
	@ColumnType(length=10)
	@ColumnComment("重定向结束时间")
    private double redirectEnd;

    // 获取开始时间
    @TableField("fetch_start")
	@ColumnType(length=10)
	@ColumnComment("获取开始时间")
    private double fetchStart;

    // 域名查询开始时间
    @TableField("domain_lookup_start")
	@ColumnType(length=20)
	@ColumnComment("域名查询开始时间")
    private double domainLookupStart;

    // 域名查询结束时间
    @TableField("domain_lookup_end")
	@ColumnType(length=13)
	@ColumnComment("域名查询结束时间")
    private double domainLookupEnd;

    // 连接开始时间
    @TableField("connect_start")
	@ColumnType(length=10)
	@ColumnComment("连接开始时间")
    private double connectStart;

    // 连接结束时间
    @TableField("connect_end")
	@ColumnType(length=10)
	@ColumnComment("连接结束时间")
    private double connectEnd;

    // 安全连接开始时间
    @TableField("secure_connection_start")
	@ColumnType(length=13)
	@ColumnComment("安全连接开始时间")
    private double secureConnectionStart;

    // 请求开始时间
    @TableField("request_start")
	@ColumnType(length=10)
	@ColumnComment("请求开始时间")
    private double requestStart;

    // 响应开始时间
    @TableField("response_start")
	@ColumnType(length=10)
	@ColumnComment("响应开始时间")
    private double responseStart;

    // 响应结束时间
    @TableField("response_end")
	@ColumnType(length=255)
	@ColumnComment("响应结束时间")
    private double responseEnd;

    // 传输大小
    @TableField("transfer_size")
	@ColumnType(length=255)
	@ColumnComment("传输大小")
    private int transferSize;

    // 编码后的主体大小
    @TableField("encoded_body_size")
	@ColumnType(length=255)
	@ColumnComment("编码后的主体大小")
    private int encodedBodySize;

    // 解码后的主体大小
    @TableField("decoded_body_size")
	@ColumnType(length=255)
	@ColumnComment("解码后的主体大小")
    private int decodedBodySize;

    // 服务器计时信息
    @TableField("server_timing")
	@ColumnType(length=255)
	@ColumnComment("服务器计时信息")
    private String serverTiming;

    // 卸载事件开始时间
    @TableField("unload_event_start")
	@ColumnType(length=10)
	@ColumnComment("卸载事件开始时间")
    private double unloadEventStart;

    // 卸载事件结束时间
    @TableField("unload_event_end")
	@ColumnType(length=13)
	@ColumnComment("卸载事件结束时间")
    private double unloadEventEnd;

    // DOM可交互时间
    @TableField("dom_interactive")
	@ColumnType(length=10)
	@ColumnComment("DOM可交互时间")
    private double domInteractive;

    // DOM内容加载事件开始时间
    @TableField("dom_content_loaded_event_start")
	@ColumnType(length=13)
	@ColumnComment("DOM内容加载事件开始时间")
    private double domContentLoadedEventStart;

    // DOM内容加载事件结束时间
    @TableField("dom_content_loaded_event_end")
	@ColumnType(length=13)
	@ColumnComment("DOM内容加载事件结束时间")
    private double domContentLoadedEventEnd;

    // DOM完成时间
    @TableField("dom_complete")
	@ColumnType(length=10)
	@ColumnComment("DOM完成时间")
    private double domComplete;

    // 页面加载事件开始时间
    @TableField("load_event_start")
	@ColumnType(length=20)
	@ColumnComment("页面加载事件开始时间")
    private double loadEventStart;

    // 页面加载事件结束时间
    @TableField("load_event_end")
	@ColumnType(length=255)
	@ColumnComment("页面加载事件结束时间")
    private double loadEventEnd;

    // 类型
    @TableField("type")
	@ColumnType(length=255)
	@ColumnComment("类型")
    private String type;

    // 重定向次数
    @TableField("redirect_count")
	@ColumnType(length=255)
	@ColumnComment("重定向次数")
    private int redirectCount;

    // 激活开始时间
    @TableField("activation_start")
	@ColumnType(length=255)
	@ColumnComment("激活开始时间")
    private double activationStart;

    // 日志类型
    @TableField("log_type")
	@ColumnType(length=10)
	@ColumnComment("日志类型")
    private String logType;

    // 时间步长
    @TableField("time_step")
	@ColumnType(length=4)
	@ColumnComment("时间步长")
    private long timeStep;
}
