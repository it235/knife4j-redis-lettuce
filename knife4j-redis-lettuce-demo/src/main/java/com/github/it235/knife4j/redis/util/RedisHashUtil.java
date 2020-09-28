//package com.github.it235.knife4j.redis.util;
//
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.TypeReference;
//import com.github.it235.manager.Knife4jRedisManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Type;
//import java.util.*;
//
///**
// * @description: Hash相关操作
// * @author: jianjun.ren
// * @date: Created in 2020/9/28 0:06
// */
//@Component
//public class RedisHashUtil extends RedisBaseUtil{
//
//    @Autowired
//    private Knife4jRedisManager knife4jRedisManager;
//
//    /**
//     * 存储单个值至map中
//     * @param redisKey redisKey中的key
//     * @param mapKey  map所对应的key
//     * @param value map所对应的值
//     */
//    public void addMapOne(String redisKey , String mapKey , Object value) {
//        addMapOne(defaultDB , redisKey , mapKey , value);
//    }
//    public void addMapOne(int dbIndex ,String redisKey , String mapKey , Object value) {
//        knife4jRedisManager.redisTemplate(dbIndex).opsForHash().put(redisKey, mapKey,value);
//    }
//
//    /**
//     * 存储整个map至redis
//     * @param key redis中存储的key
//     * @param map 需缓存的Map
//     */
//    public void addMapAll(String key , Map map) {
//        addMapAll(defaultDB ,key,map);
//    }
//    public void addMapAll(int dbIndex ,String key , Map map) {
//        knife4jRedisManager.redisTemplate(dbIndex).opsForHash().putAll(key, map);
//    }
//
//    /**
//     * 获取整个HashMap
//     * @param redisKey redis中存储的key
//     * @param keyType map中key的类型
//     * @param valueType map中value的类型
//     * @return 整个Map
//     */
//    public <K,V> Map<K , V> getMapAll(String redisKey , Class<K> keyType , Class<V> valueType) {
//        return getMapAll(defaultDB , redisKey ,keyType , valueType);
//    }
//    public <K,V> Map<K , V> getMapAll(int dbIndex ,String redisKey , Class<K> keyType , Class<V> valueType) {
//        Map<Object, Object> entries = getMapAll(dbIndex ,redisKey);
//        Type type = new TypeReference<Map<K, V>>(keyType, valueType) {}.getType();
//        Map<K,V> retEntries = JSONArray.parseObject(JSON.toJSONString(entries), type);
//        return retEntries;
//    }
//
//
//    public Map<Object , Object> getMapAll(String redisKey) {
//        return getMapAll(defaultDB ,redisKey);
//    }
//    public Map<Object , Object> getMapAll(int dbIndex ,String redisKey) {
//        Map<Object, Object> entries = knife4jRedisManager.redisTemplate(dbIndex).opsForHash().entries(redisKey);
//        return entries;
//    }
//
//    /**
//     * 获取redis中hash的所有value
//     * @param redisKey
//     * @return
//     */
//    public List<Object> getMapValues(String redisKey) {
//        return getMapValues(defaultDB ,redisKey);
//    }
//    public List<Object> getMapValues(int dbIndex ,String redisKey) {
//        return knife4jRedisManager.redisTemplate(dbIndex).opsForHash().values(redisKey);
//    }
//
//    /**
//     * 删除Map中的某个键值对
//     * @param redisKey
//     * @param mapKey
//     * @return 返回影响数量
//     */
//    public Long deleteMapVal(String redisKey , Object ... mapKey) {
//        return deleteMapVal(defaultDB , redisKey , mapKey);
//    }
//    public Long deleteMapVal(int dbIndex ,String redisKey , Object ... mapKey) {
//        return knife4jRedisManager.redisTemplate(dbIndex).opsForHash().delete(redisKey , mapKey);
//    }
//    /**
//     * 确定hashkey是否存在
//     * @param redisKey redis存储的key
//     * @param mapKey 需要确定的map对象key
//     * @return
//     */
//    public boolean hasKey(String redisKey , String mapKey) {
//        return hasKey(defaultDB ,redisKey ,mapKey);
//    }
//    public boolean hasKey(int dbIndex ,String redisKey , String mapKey) {
//        return	knife4jRedisManager.redisTemplate(dbIndex).opsForHash().hasKey(redisKey , mapKey);
//    }
//
//    /**
//     * 取出Map中的属性为JSONArray的值，并转换为List
//     * @param redisKey
//     * @param mapKey
//     * @param t
//     * @param <T>
//     * @return
//     */
//    public <T> List<T> getMapValAtList(String redisKey, String mapKey , Class<T> t){
//        return getMapValAtList(defaultDB , redisKey ,mapKey ,t);
//    }
//    public <T> List<T> getMapValAtList(int dbIndex ,String redisKey, String mapKey , Class<T> t){
//        Object mapVal = getMapVal(redisKey, mapKey);
//        if(mapVal == null){
//            return null;
//        }
//        List<T> ts = JSONArray.parseArray(String.valueOf(mapVal), t);
//        return ts;
//    }
//
//    /**
//     * 取出Map中的属性为单值或Bean对象的数据，并转化成Bean
//     * @param redisKey
//     * @param mapKey
//     * @param t
//     * @param <T>
//     * @return
//     */
//    public <T> T getMapValAtBean(String redisKey, String mapKey , Class<T> t){
//        return getMapValAtBean(defaultDB , redisKey,mapKey,t);
//    }
//    public <T> T getMapValAtBean(int dbIndex ,String redisKey, String mapKey , Class<T> t){
//        Object mapVal = getMapVal(redisKey, mapKey);
//        if(mapVal == null){
//            return null;
//        }
//        if(mapVal instanceof String){
//            return (T)String.valueOf(mapVal);
//        }
//        return JSONObject.parseObject(String.valueOf(mapVal), t);
//    }
//
//    public Object getMapVal(String redisKey, String mapKey) {
//        return  getMapVal(defaultDB ,redisKey ,mapKey);
//    }
//    public Object getMapVal(int dbIndex ,String redisKey, String mapKey) {
//        Object o = knife4jRedisManager.redisTemplate(dbIndex).opsForHash().get(redisKey, mapKey);
//        return o;
//    }
//
//    public void setMapVal(String redisKey, String mapKey, String mapValue) {
//        setMapVal(defaultDB , redisKey , mapKey ,mapValue);
//    }
//    public void setMapVal(int dbIndex ,String redisKey, String mapKey, String mapValue) {
//        knife4jRedisManager.redisTemplate(dbIndex).opsForHash().put(redisKey, mapKey, mapValue);
//    }
//
//    /**
//     * 从哈希中获取给定key的值
//     * @param redisKey redis存储的key
//     * @param mapKeys 需要去出的key的集合
//     * @return 值列表
//     */
//    public <T> List<T> multiGetHash(String redisKey , List<Object> mapKeys , Class<T> valueType) {
//        return multiGetHash(defaultDB , redisKey , mapKeys , valueType);
//    }
//    public <T> List<T> multiGetHash(int dbIndex ,String redisKey , List<Object> mapKeys , Class<T> valueType) {
//        List<T> retList = new ArrayList<>();
//        List<Object> objects = multiGetHash(redisKey, mapKeys);
//        for (Object object : objects) {
//            T t = JSONObject.parseObject(String.valueOf(object), valueType);
//            retList.add(t);
//        }
//        return  retList;
//    }
//    public List<Object> multiGetHash(String redisKey , List<Object> mapKeys) {
//        return multiGetHash(defaultDB , redisKey ,mapKeys);
//    }
//    public List<Object> multiGetHash(int dbIndex ,String redisKey , List<Object> mapKeys) {
//        return  knife4jRedisManager.redisTemplate(dbIndex).opsForHash().multiGet(redisKey , mapKeys);
//    }
//
//    /**
//     * 获取所有map中的key
//     * @param redisKey
//     * @return
//     */
//    public Set<String> getHashKeys(String redisKey) {
//        return getHashKeys(defaultDB , redisKey);
//    }
//    public Set<String> getHashKeys(int dbIndex ,String redisKey) {
//        Set<Object> keys = knife4jRedisManager.redisTemplate(dbIndex).opsForHash().keys(redisKey);
//        Set<String> retKeys = new HashSet<>();
//        for (Object key : keys) {
//            retKeys.add(String.valueOf(key));
//        }
//        return retKeys;
//    }
//
//    /**
//     * 获取所有map中的key的数量
//     * @param redisKey redis中的key
//     * @return key的数量
//     */
//    public int getHashSize(String redisKey) {
//        return getHashSize(defaultDB , redisKey);
//    }
//    public int getHashSize(int dbIndex ,String redisKey) {
//        Set<Object> keys = knife4jRedisManager.redisTemplate(dbIndex).opsForHash().keys(redisKey);
//        if(keys == null){
//            return 0;
//        }
//        return keys.size();
//    }
//
//
//}
