package com.alinesno.infra.common.web.adapter.login.controller;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.dto.LoginBodyDto;
import com.alinesno.infra.common.web.adapter.dto.menus.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class CommonLoginController {

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBodyDto loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = UUID.randomUUID().toString() ;
        ajax.put(TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {

        Map<String, Object> data = new HashMap<>();
        // 将数据填充到data中...
        data.put("permissions", new String[]{"*:*:*"});

        Map<String, Object> user = new HashMap<>();
        user.put("createBy", "admin");
        user.put("createTime", "2023-04-23 16:11:38");
        user.put("updateBy", null);
        user.put("updateTime", null);
        user.put("remark", "管理员");
        user.put("userId", 1);
        user.put("deptId", 103);
        user.put("userName", "admin");
        user.put("nickName", "AIP技术团队");
        user.put("email", "aip-team@163.com");
        user.put("phonenumber", "15888888888");
        user.put("sex", "1");
        user.put("avatar", "");
        user.put("password", "");
        user.put("status", "0");
        user.put("delFlag", "0");
        user.put("loginIp", "");
        user.put("loginDate", "2023-09-21T16:54:12.000+08:00");

        Map<String, Object> dept = new HashMap<>();
        dept.put("createBy", null);
        dept.put("createTime", null);
        dept.put("updateBy", null);
        dept.put("updateTime", null);
        dept.put("remark", null);
        dept.put("deptId", 103);
        dept.put("parentId", 101);
        dept.put("ancestors", "0,100,101");
        dept.put("deptName", "研发部门");
        dept.put("orderNum", 1);
        dept.put("leader", "AIP技术团队");
        dept.put("phone", null);
        dept.put("email", null);
        dept.put("status", "0");
        dept.put("delFlag", null);
        dept.put("parentName", null);
        dept.put("children", new Object[]{});

        user.put("dept", dept);

        Map<String, Object> role = new HashMap<>();
        role.put("createBy", null);
        role.put("createTime", null);
        role.put("updateBy", null);
        role.put("updateTime", null);
        role.put("remark", null);
        role.put("roleId", 1);
        role.put("roleName", "超级管理员");
        role.put("roleKey", "admin");
        role.put("roleSort", 1);
        role.put("dataScope", "1");
        role.put("menuCheckStrictly", false);
        role.put("deptCheckStrictly", false);
        role.put("status", "0");
        role.put("delFlag", null);
        role.put("flag", false);
        role.put("menuIds", null);
        role.put("deptIds", null);
        role.put("permissions", null);
        role.put("admin", true);

        user.put("roles", new Object[]{role});

        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", user.get("roles"));
        ajax.put("permissions", data.get("permissions"));

        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {

        Menu dashboardMenu = new Menu("Dashboard", "/dashboard", false, "noRedirect", "Layout", true, new Menu.Meta("仪盘表", "dashboard", false, null), List.of(
                new Menu("Dashboard", "index", false, false , "dashboard", new Menu.Meta("概览", "dashboard", false, null))
        ));

        Menu projectMenu = new Menu("Project", "/project", false, "noRedirect", "Layout", true, new Menu.Meta("项目管理", "post", false, null),
                List.of(
                        new Menu("Project", "ops/logback/project/index", false,false,  "ops/logback/project/index", new Menu.Meta("项目管理", "druid", false, null))
                ));

        Menu loggerMenu = new Menu("Logger", "/logger", false, "noRedirect", "Layout", true, new Menu.Meta("日志分析", "log", false, null),
                List.of(
                        new Menu("LogStorage", "ops/logback/logStorage/index", false,false,  "ops/logback/logStorage/index", new Menu.Meta("运行日志", "form", false, null)),
                        new Menu("BusinessLog", "ops/logback/businessLog/index", false,false,  "ops/logback/businessLog/index", new Menu.Meta("业务日志", "tree", false, null)),
                        new Menu("DatabaseLog", "ops/logback/databaseLog/index", false,false,  "ops/logback/databaseLog/index", new Menu.Meta("数据库日志", "user", false, null)),
                        new Menu("ContainerLog", "ops/logback/containerLog/index", false,false,  "ops/logback/containerLog/index", new Menu.Meta("容器日志", "form", false, null)),
                        new Menu("FrontLog", "ops/logback/frontLog/index", false,false,  "ops/logback/frontLog/index", new Menu.Meta("前端监控", "guide", false, null)),
                        new Menu("Inspection", "ops/logback/nginx/index", false,false,  "ops/logback/nginx/index", new Menu.Meta("Nginx日志", "druid", false, null)),
                        new Menu("Account", "ops/logback/inspection/index", false,false,  "ops/logback/inspection/index", new Menu.Meta("巡检日志", "online", false, null))
                ));

        Menu systemMenu = new Menu("Monitor", "/monitor", false, "noRedirect", "Layout", true, new Menu.Meta("系统配置", "monitor", false, null),
                List.of(
                        new Menu("Analyse", "ops/logback/analyse/index", false,false,  "ops/logback/analyse/index", new Menu.Meta("请求监控", "form", false, null)),
                        new Menu("Config", "ops/logback/config/index", false,false,  "ops/logback/config/index", new Menu.Meta("日志配置", "form", false, null))
                ));

        List<Menu> menus = List.of(dashboardMenu, projectMenu , loggerMenu , systemMenu) ;

        return AjaxResult.success(menus) ;
    }

}