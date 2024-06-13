package com.alinesno.infra.ops.logback.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;

/**
 * 巡检数据
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
public class InspectionDataDto {

	private String name;
	private String nameCode;
	private String jsonData;
	private String busType;
	private String runStatus;
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
		return "InspectionLogEntity [name=" + name + ", nameCode=" + nameCode + ", jsonData=" + jsonData + ", busType="
				+ busType + ", runStatus=" + runStatus + ", totalTime=" + totalTime + "]";
	}

}
