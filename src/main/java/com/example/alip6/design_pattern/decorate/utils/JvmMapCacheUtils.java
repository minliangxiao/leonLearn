package com.example.alip6.design_pattern.decorate.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * jvm 一级缓存工具类
 */
public class JvmMapCacheUtils {

     private static Map<String,String> caches = new ConcurrentHashMap<>();

     public static  <T> T getEntity(String key,Class<T> t){
         String json = caches.get(key);
         return JSONObject.parseObject(json,t);
     }

     public static void  putEntity(String key,Object o){
         String json = JSONObject.toJSONString(o);
         caches.put(key,json);
     }
}
