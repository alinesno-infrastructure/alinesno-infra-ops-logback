package com.alinesno.infra.ops.logback.api.provider;

import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.ops.logback.api.dto.InspectionDataDto;
import com.alinesno.infra.ops.logback.entity.InspectionDataEntity;
import com.alinesno.infra.ops.logback.service.IInspectionDataService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 获取文件上传的配置
 * 
 * @author LuoAnDong
 * @since 2022年10月29日 上午6:23:43
 */
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
public class InspectionProvider {

	private static final Logger log = LoggerFactory.getLogger(InspectionProvider.class);

	@Autowired
	private IInspectionDataService inspectService;

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
			@RequestHeader(value = "User-Key" , required = true) String userKey ,
			@RequestParam(value = "algorithm" , required = false) String algorithm 
			) throws IOException {

		log.debug("user-key = {}" , userKey) ;
		
		// 文件上传检查
		File f = new File("/tmp/template.json");
		pluginFile.transferTo(f);

		String json = FileUtils.readFileToString(f);
		log.debug("json object = \r\n {}", json);

		FileUtils.forceDeleteOnExit(f);
		
		InspectionDataDto dto = JSONObject.parseObject(algorithm, InspectionDataDto.class) ;
		
		log.debug("algorithm = {}" , algorithm) ;
		log.debug("dto = {}" , dto.toString()) ; 
		
		long accountId = 1L ;

		InspectionDataEntity e = new InspectionDataEntity();
	
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
