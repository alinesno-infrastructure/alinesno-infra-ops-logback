package com.alinesno.infra.ops.logback.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 支持的文档类型
 */
@Getter
public enum ProviderChannelEnum {

    ALIYUN("Aliyun", "用于连接和管理阿里云服务", "fa-brands fa-alipay"),
    DOCKER("Docker", "用于容器化应用部署和管理", "fa-brands fa-docker"),
    KUBERNETES("Kubernetes", "用于容器编排和集群管理", "fa-brands fa-wordpress"),
    JIRA("Jira", "用于敏捷项目管理和问题追踪", "fa-brands fa-envira"),
    JENKINS("Jenkins", "用于持续集成和持续交付", "fa-brands fa-jenkins"),
    PROMETHEUS("Prometheus", "用于监控和警报通知", "fa-brands fa-product-hunt"),
    SERVER("Server", "用于服务器管理和监控", "fa-solid fa-server"),
    SPRING_BOOT("SpringBoot", "用于构建和部署Spring Boot应用", "fa-solid fa-rocket"),
    JAVA_APPLICATION("JavaApplication", "用于Java应用程序的部署和管理", "fa-brands fa-java"),
    TOMCAT("Tomcat", "用于Apache Tomcat服务器的部署和管理", "fa-solid fa-truck-fast"),
    ZBOX("Zbox", "用于项目管理和团队协作", "fa-solid fa-user-shield");

    private final String name;
    private final String desc;
    private final String icon;

    ProviderChannelEnum(String name, String desc, String icon) {
        this.name = name;
        this.desc = desc;
        this.icon = icon;
    }

    public static List<ProviderChannelEnum> getAllDocumentTypes() {
        return Arrays.asList(ProviderChannelEnum.values());
    }

    public static Object[] getAllNames() {
        ProviderChannelEnum[] documentTypes = ProviderChannelEnum.values();
        Object[] names = new Object[documentTypes.length];
        for (int i = 0; i < documentTypes.length; i++) {
            names[i] = documentTypes[i].getName();
        }
        return names;
    }

    public static String getAllNameStr() {

        StringBuilder names = new StringBuilder();

        for(ProviderChannelEnum d : getAllDocumentTypes()){
            names.append(",")
                 .append(d.getName());
        }

        return names.toString();
    }
}
