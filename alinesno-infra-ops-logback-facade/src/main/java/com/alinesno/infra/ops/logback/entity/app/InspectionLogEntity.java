package com.alinesno.infra.ops.logback.entity.app;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 巡检记录日志
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("inspection_data")
@Data
public class InspectionLogEntity extends InfraBaseEntity {

	@Excel(name="巡检任务名称")
	@TableField("name")
	@ColumnType(length=255)
	@ColumnComment("巡检任务名称")
	private String name;
	
	@Excel(name="巡检任务代码")
	@TableField("name_code")
	@ColumnType(length=50)
	@ColumnComment("巡检任务代码")
	private String nameCode;

	@Excel(name="结果格式数据")
	@TableField("json_data")
	@ColumnType(length=255)
	@ColumnComment("结果格式数据")
	private String jsonData;

	@Excel(name="业务类型")
	@TableField("bus_type")
	@ColumnType(length=20)
	@ColumnComment("业务类型")
	private String busType;

	@Excel(name="运行状态")
	@TableField("run_status")
	@ColumnType(length=32)
	@ColumnComment("运行状态")
	private String runStatus;

	@Excel(name="任务时间")
	@TableField("total_time")
	@ColumnType(length=16)
	@ColumnComment("任务时间")
	private String totalTime;
}
