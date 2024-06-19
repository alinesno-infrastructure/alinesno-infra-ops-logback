package com.alinesno.infra.ops.logback.api.controller;

import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import com.alinesno.infra.ops.logback.entity.ProjectEntity;
import com.alinesno.infra.ops.logback.service.IProjectService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 应用构建Controller
 * 处理与ProjectEntity相关的请求
 * 继承自BaseController类并实现IProjectService接口
 * 
 * @version 1.0.0
 * @since 2023-09-30
 */
@Slf4j
@Api(tags = "Application")
@RestController
@Scope("prototype")
@RequestMapping("/api/infra/ops/logback/project")
public class ProjectController extends BaseController<ProjectEntity, IProjectService> {

    @Autowired
    private IProjectService service;

    /**
     * 获取ApplicationEntity的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model   Model对象。
     * @param page    DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", ToStringBuilder.reflectionToString(page));

        long userId = CurrentAccountJwt.getUserId();
        long count = service.count(new LambdaQueryWrapper<ProjectEntity>().eq(ProjectEntity::getOperatorId , userId));

        // 初始化默认应用
        if (count == 0) {
            service.initDefaultApp(CurrentAccountJwt.getUserId());
        }

        return this.toPage(model, this.getFeign(), page);
    }

    /**
     * 保存文件类型
     * @param projectId
     * @param documentStr
     */
    @PostMapping("/saveDocumentType")
    public void saveDocumentType(@Validated @RequestParam String projectId,
                                 @Validated @RequestBody String documentStr) {
        // 在这里调用您的 saveDocumentType 方法，传入 projectId 和 documentStr
        service.saveDocumentType(projectId, documentStr);
    }


    /**
     * 获取默认应用地址
     * @return
     */
    @GetMapping("/defaultProject")
    public AjaxResult defaultProject(){
        long userId = CurrentAccountJwt.getUserId();
        ProjectEntity e = service.getDefaultProject(userId) ;
        return AjaxResult.success("操作成功." , e.getProjectCode()) ;
    }

    @Override
    public IProjectService getFeign() {
        return this.service;
    }
}