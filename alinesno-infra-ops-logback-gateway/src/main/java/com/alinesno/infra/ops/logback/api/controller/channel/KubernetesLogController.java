package com.alinesno.infra.ops.logback.api.controller.channel;

import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import com.alinesno.infra.ops.logback.entity.channel.KubernetesLogEntity;
import com.alinesno.infra.ops.logback.service.channel.IKubernetesLogService;
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
 * 处理与KubernetesLogEntity相关的请求的Controller。
 * 继承自BaseController类并实现IKubernetesLogService接口。
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@Api(tags = "KubernetesLog")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/ops/logback/containerLog")
public class KubernetesLogController extends BaseController<KubernetesLogEntity, IKubernetesLogService> {

    @Autowired
    private IKubernetesLogService service;

    /**
     * 获取KubernetesLogEntity的DataTables数据。
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
    public IKubernetesLogService getFeign() {
        return this.service;
    }
}

