package com.alinesno.infra.ops.logback.api.controller;

import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import com.alinesno.infra.ops.logback.entity.LogStorageEntity;
import com.alinesno.infra.ops.logback.service.ILogStorageService;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理与LogStorageEntity相关的请求的Controller。
 * 继承自BaseController类并实现ILogStorageEntityService接口。
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@Api(tags = "LogStorageEntity")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/ops/logback/LogStorage")
public class LogStorageController extends BaseController<LogStorageEntity, ILogStorageService> {

    @Autowired
    private ILogStorageService service;

    /**
     * 获取LogStorageEntity的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model Model对象。
     * @param page DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", ToStringBuilder.reflectionToString(page));
        return this.toPage(model, this.getFeign(), page);
    }

    @Override
    public ILogStorageService getFeign() {
        return this.service;
    }
}
