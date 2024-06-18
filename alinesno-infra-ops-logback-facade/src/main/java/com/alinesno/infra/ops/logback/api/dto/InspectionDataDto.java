package com.alinesno.infra.ops.logback.api.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 检查数据的数据传输对象类。
 * 该类用于封装检查相关的数据，以便在系统中进行传输和处理。
 * 实现Serializable接口，以便对象可以被序列化，用于网络传输或持久化存储。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Data
@ToString
public class InspectionDataDto implements Serializable  {

    /**
     * 检查项的名称。
     * 用于标识检查项的名称，方便用户理解和操作。
     */
	private String name;

    /**
     * 检查项的代码。
     * 用于唯一标识检查项，通常与系统中的代码表对应。
     */
	private String nameCode;

    /**
     * 检查项的配置数据。
     * 以JSON格式存储检查项的详细配置信息，用于配置检查项的具体行为和规则。
     */
	private String jsonData;

    /**
     * 业务类型。
     * 用于标识检查项所针对的业务类型，以便对不同的业务进行区分和处理。
     */
	private String busType;

    /**
     * 运行状态。
     * 用于标识检查项当前的运行状态，如运行中、暂停、已完成等。
     */
	private String runStatus;

    /**
     * 总运行时间。
     * 记录检查项自启动以来的总运行时间，用于统计和监控检查项的运行情况。
     */
	private String totalTime;

}

