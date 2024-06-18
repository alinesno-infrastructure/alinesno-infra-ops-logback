package com.alinesno.infra.ops.logback.api.provider;

import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.ops.logback.api.dto.InspectionDataDto;
import com.alinesno.infra.ops.logback.entity.app.InspectionLogEntity;
import com.alinesno.infra.ops.logback.service.app.IInspectionLogService;
import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 获取文件上传的配置
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
public class InspectionProvider {

	@Autowired
	private IInspectionLogService inspectService;

	/**
	 * 接收多参数请求
	 *
	 * @param pluginFile
	 * @param userKey
	 * @param algorithm
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "/v1/api/ops/logback/inspectData", consumes = { "multipart/form-data" })
	public Object updateAlgorithm(
			@RequestPart(value = "pluginFile", required = false) MultipartFile pluginFile,
			@RequestHeader(value = "userKey" , required = true) String userKey ,
			@RequestParam(value = "algorithm" , required = true) String algorithm
			) throws IOException {

		log.debug("user-key = {}" , userKey) ;
		
		// 文件上传检查
		String json = null ;
		if(pluginFile != null){
			File f = new File("/tmp/template.json");
			pluginFile.transferTo(f);

			json = FileUtils.readFileToString(f , Charset.defaultCharset());
			log.debug("json object = \r\n {}", json);

			FileUtils.forceDeleteOnExit(f);
		}

		Assert.hasLength(algorithm , "巡检主体为空.");
		InspectionDataDto dto = JSONObject.parseObject(algorithm, InspectionDataDto.class) ;
		
		log.debug("algorithm = {}" , algorithm) ;
		log.debug("dto = {}" , dto.toString()) ; 
		
		long accountId = 1L ;

		InspectionLogEntity e = new InspectionLogEntity();
	
		String pipelineTime = dto.getTotalTime() ; 
		String timeStr = pipelineTime.contains("and") ? pipelineTime.substring(0 , pipelineTime.indexOf("and")):"None" ; 
	
		e.setName(dto.getName());
		e.setNameCode(dto.getNameCode());
		e.setBusType(dto.getBusType());
		e.setTotalTime(timeStr);
		e.setJsonData(json);
		e.setRunStatus(dto.getRunStatus()) ;
		e.setOperatorId(accountId);
		
		inspectService.save(e);

		return "success";
	}

}
