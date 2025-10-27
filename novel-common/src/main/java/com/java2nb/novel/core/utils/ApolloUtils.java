package com.java2nb.novel.core.utils;

import com.alibaba.fastjson2.JSON;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

@Slf4j
public class ApolloUtils {
    private static final String DEFAULT_NAMESPACE = "application";
    private static final Map<String, CacheEntry> cacheMap = new ConcurrentHashMap<>();

    public ApolloUtils() {
    }

    public static <T> T cacheGetOrInvoke(Map<String, CacheEntry> configCacheMap, String namespace, String key, String defaultValue, Function<String, T> functionP1) {
        return originCacheGetOrInvoke(configCacheMap, namespace, key, defaultValue, functionP1);
    }

    private static <T> T originCacheGetOrInvoke(Map<String, CacheEntry> configCacheMap, String namespace, String key, String defaultValue, Function<String, T> functionP1) {
        String cacheKey = "ApolloUtils:" + namespace + ":" + key;
        CacheEntry cacheEntry = configCacheMap.get(cacheKey);
        if (cacheEntry == null) {
            cacheEntry = configCacheMap.computeIfAbsent(cacheKey, (tmp) -> {
                Config config = ConfigService.getConfig(namespace);
                String value = config.getProperty(key, defaultValue);
                CacheEntry result = parseRun(key, value, functionP1);
                Set<String> interestedKeys = new HashSet<>();
                interestedKeys.add(key);
                config.addChangeListener((changeEvent) -> {
                    ConfigChange configChange = changeEvent.getChange(key);
                    if (configChange == null) {
                        log.warn("configChange event come but configChange is null key={}", key);
                    } else {
                        String newValue = defaultValue;
                        if (configChange.getNewValue() != null) {
                            newValue = configChange.getNewValue();
                        }

                        configCacheMap.put(cacheKey, parseRun(key, newValue, functionP1));
                    }
                }, interestedKeys);
                return result;
            });
        }

        return (T) cacheEntry.cacheObj();
    }

    private static <T> T cacheGetOrInvoke(String namespace, String key, String defaultValue, Function<String, T> functionP1) {
        return cacheGetOrInvoke(cacheMap, namespace, key, defaultValue, functionP1);
    }

    private static <T> CacheEntry parseRun(String key, String value, Function<String, T> functionP1) {
        try {
            T result = functionP1.apply(value);
            return CacheEntry.create(result);
        } catch (Exception var4) {
            log.error("parseConfig error key={}", key, var4);
            throw var4;
        }
    }

    public static String getString(String nameSpace, String key) {
        return cacheGetOrInvoke(nameSpace, key, "", (configStr) -> configStr);
    }

    public static String getString(String key) {
        return getString("application", key);
    }

    public static <T> List<T> parseList(String nameSpace, String key, Class<T> clazz) {
        return cacheGetOrInvoke(nameSpace, key, "[]", (configStr) -> JSON.parseArray(configStr, clazz));
    }

    public static <T> List<T> getObjConfigs(String key, Class<T> clazz) {
        return getObjConfigs("application", key, clazz);
    }

    public static <T> List<T> getObjConfigs(String namespace, String key, Class<T> clazz) {
        return parseList(namespace, key, clazz);
    }

    public static <T> T parseObject(String nameSpace, String key, Class<T> clazz) {
        return cacheGetOrInvoke(nameSpace, key, "{}", (configStr) -> {
            return JSON.parseObject(configStr, clazz);
        });
    }

    public static <T> T getObjConfig(String key, Class<T> clazz) {
        return getObjConfig("application", key, clazz);
    }

    public static <T> T getObjConfig(String namespace, String key, Class<T> clazz) {
        return parseObject(namespace, key, clazz);
    }

    public static <T> T getObject(String namespace, String key, Function<String, T> function) {
        return cacheGetOrInvoke(namespace, key, "{}", function);
    }

    public static <T> T getObject(String key, Function<String, T> function) {
        return getObject("application", key, function);
    }

    private record CacheEntry(Object cacheObj) {

        public static CacheEntry create(Object cacheObj) {
            return new CacheEntry(cacheObj);
        }

    }
}