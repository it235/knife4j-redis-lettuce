///*
//package com.github.it235.knife4j.redis.util;
//
//import com.alibaba.fastjson.parser.ParserConfig;
//import com.github.it235.knife4j.serializer.CustomFastJsonRedisSerializer;
//import com.github.it235.knife4j.serializer.CustomStringRedisSerializer;
//import com.github.it235.manager.Knife4jRedisManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//*/
///**
// * @description: redis工具类基类，集成通用的方法
// * @author: jianjun.ren
// * @date: Created in 2020/9/27 11:20
// *//*
//
//@Component
//public class RedisBaseUtil {
//
//    @Autowired
//    private Knife4jRedisManager knife4jRedisManager;
//
//    @ConditionalOnProperty(prefix = "knife4j.redis", name = "enableJsonSerial", havingValue = "fastjson")
//    @PostConstruct
//    public void init(){
//        //自定义序列化方式，去掉原序列化中的@全类名标志，支持不同package对象反序列化
//        Map<String, RedisTemplate> redisTemplateMap = knife4jRedisManager.getRedisTemplateMap();
//        CustomFastJsonRedisSerializer<Object> jackson2JsonRedisSerializer = new CustomFastJsonRedisSerializer<>(Object.class);
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(false);
//        CustomStringRedisSerializer stringRedisSerializer = new CustomStringRedisSerializer();
//        for (Map.Entry<String, RedisTemplate> entry : redisTemplateMap.entrySet()) {
//            RedisTemplate redisTemplate = entry.getValue();
//            redisTemplate.setKeySerializer(stringRedisSerializer);
//            redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//            redisTemplate.setHashKeySerializer(stringRedisSerializer);
//            redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//        }
//    }
//
//    protected int defaultDB = 0;
//
//    public void delete(String key) {
//        delete(0,key);
//    }
//    public void delete(int dbIndex ,String key) {
//        knife4jRedisManager.redisTemplate(dbIndex).delete(key);
//    }
//
//    public boolean set(String key, Object value) {
//        return set(0,key,value);
//    }
//    public boolean set(int dbIndex ,String key, Object value) {
//        try {
//            knife4jRedisManager.redisTemplate(dbIndex).opsForValue().set(key, value);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public void delete(Collection<String> keys){
//        delete(defaultDB , keys);
//    }
//    public void delete(int dbIndex ,Collection<String> keys){
//        knife4jRedisManager.redisTemplate(dbIndex).delete(keys);
//    }
//
//    public Set<String> getKeys(String redisKey) {
//        return getKeys(0,redisKey);
//    }
//    public Set<String> getKeys(int dbIndex ,String redisKey) {
//        Set<Object> keys = knife4jRedisManager.redisTemplate(dbIndex).opsForHash().keys(redisKey);
//        Set<String> retKeys = new HashSet<>();
//        for (Object key : keys) {
//            retKeys.add(String.valueOf(key));
//        }
//        return retKeys;
//    }
//
//    */
///**
//     * 每个redis
//     * 指定缓存失效时间
//     * @param key 键
//     * @param time 时间(秒)
//     * @return
//     *//*
//
//    public boolean expire(String key, long time) {
//        return expire(defaultDB , key,time);
//    }
//    public boolean expire(int dbIndex ,String key, long time) {
//        try {
//            if (time > 0) {
//                knife4jRedisManager.redisTemplate(dbIndex).expire(key, time, TimeUnit.SECONDS);
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//    */
///**
//     * 根据key 获取过期时间
//     * @param key 键 不能为null
//     * @return 时间(秒) 返回0代表为永久有效
//     *//*
//
//    public long getExpire(int dbIndex , String key) {
//        return knife4jRedisManager.redisTemplate(dbIndex).getExpire(key, TimeUnit.SECONDS);
//    }
//    public long getExpire(String key) {
//        return getExpire(defaultDB , key);
//    }
//    */
///**
//     * 判断key是否存在
//     * @param key 键
//     * @return true 存在 false不存在
//     *//*
//
//    public boolean hasKey(String key) {
//        return hasKey(defaultDB , key);
//    }
//    public boolean hasKey(int dbIndex ,String key) {
//        try {
//            return knife4jRedisManager.redisTemplate(dbIndex).hasKey(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//}
//*/
