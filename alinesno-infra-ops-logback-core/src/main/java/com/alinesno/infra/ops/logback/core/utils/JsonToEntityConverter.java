package com.alinesno.infra.ops.logback.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * JSON转换为实体对象的工具类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class JsonToEntityConverter {

    private static final Logger log = LoggerFactory.getLogger(JsonToEntityConverter.class) ;

//    /**
//     * 将JSON转换为LogResource对象列表
//     *
//     * @param json JSON字符串
//     * @return LogResource对象列表
//     */
//    public static List<LogResource> JsonToLog(String json) {
//        List<LogResource> logResources = new ArrayList<>();
//        JSONObject jsonObject = JSON.parseObject(json);
//
//        JSONArray resourceLogs = jsonObject.getJSONArray("resourceLogs");
//        for (int i = 0; i < resourceLogs.size(); i++) {
//            JSONObject resourceLog = resourceLogs.getJSONObject(i);
//            JSONObject resource = resourceLog.getJSONObject("resource");
//            JSONArray attributes = resource.getJSONArray("attributes");
//            JSONObject serviceNameAttribute = attributes.getJSONObject(0);
//            String serviceName = serviceNameAttribute.getJSONObject("value").getString("stringValue");
//
//            LogResource logResource = new LogResource();
//            logResource.setResourceName(serviceName);
//            logResources.add(logResource);
//        }
//
//        return logResources;
//    }

}