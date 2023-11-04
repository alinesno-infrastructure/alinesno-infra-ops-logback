package com.alinesno.infra.ops.logback.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
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
@TableName("inspection_data")
@Data
public class InspectionDataEntity extends InfraBaseEntity {

	@Excel(name="巡检名称")
	@TableField("name")
	@ColumnType(length=255)
	@ColumnComment("姓名")
	private String name;
	
	@Excel(name="巡检名称")
	@TableField("name_code")
	@ColumnType(length=50)
	@ColumnComment("无法确定")
	private String nameCode;

	@Excel(name="巡检数据")
	@TableField("json_data")
	@ColumnType(length=255)
	@ColumnComment("jsonData")
	private String jsonData;

	@Excel(name="业务类型")
	@TableField("bus_type")
	@ColumnType(length=20)
	@ColumnComment("公交车类型")
	private String busType;

	@Excel(name="运行状态")
	@TableField("run_status")
	@ColumnType(length=1)
	@ColumnComment("运行状态")
	private String runStatus;

	@Excel(name="业务类型")
	@TableField("total_time")
	@ColumnType(length=8)
	@ColumnComment("总时间")
	private String totalTime;
}
