package com.alinesno.infra.ops.logback.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 巡检记录日志
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
@SuppressWarnings("serial")
@TableName("inspection_data")
public class InspectionDataEntity extends InfraBaseEntity {

	@Excel(name="巡检名称")
	@TableField("name")
	private String name;
	
	@Excel(name="巡检名称")
	@TableField("name_code")
	private String nameCode;

	@Excel(name="巡检数据")
	@TableField("json_data")
	private String jsonData;

	@Excel(name="业务类型")
	@TableField("bus_type")
	private String busType;

	@Excel(name="运行状态")
	@TableField("run_status")
	private String runStatus;

	@Excel(name="业务类型")
	@TableField("total_time")
	private String totalTime;

	public String getNameCode() {
		return nameCode;
	}

	public void setNameCode(String nameCode) {
		this.nameCode = nameCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	@Override
	public String toString() {
		return "InspectionDataEntity [name=" + name + ", nameCode=" + nameCode + ", jsonData=" + jsonData + ", busType="
				+ busType + ", runStatus=" + runStatus + ", totalTime=" + totalTime + "]";
	}

}
