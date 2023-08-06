package com.alinesno.infra.ops.logback.consumer.cache;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppNameCache {

    public static final String APP_NAME_SET = "alinesno:infra:appname:set";

    public static Map<String, Set<String>> appName = new ConcurrentHashMap<>();
}
