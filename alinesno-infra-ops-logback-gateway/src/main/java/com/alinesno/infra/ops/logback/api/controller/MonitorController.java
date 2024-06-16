package com.alinesno.infra.ops.logback.api.controller;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import com.alinesno.infra.ops.logback.dto.MonitorReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 统计管理界面
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/monitor")
public class MonitorController extends SuperController {

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public Object list(@RequestBody MonitorReq monitorReq){
//        return new ApiResult(monitorService.list(monitorReq));
        return AjaxResult.success() ;
    }

    /**
     * 关闭本次告警，状态置为0正常
     * @param id
     * @return
     */
    @RequestMapping(value = "/close", method = {RequestMethod.GET, RequestMethod.POST})
    public Object close(@RequestParam String id){
//        Assert.isTrue(StringUtils.isNotBlank(id), "未获取到对象ID");
//        Monitor monitor = monitorService.findById(id);
//        Assert.notNull(monitor, "未获取到对象");
//        monitor.setStatus(Constants.YES);
//        monitorService.update(monitor);

        return AjaxResult.success() ;
    }

}
