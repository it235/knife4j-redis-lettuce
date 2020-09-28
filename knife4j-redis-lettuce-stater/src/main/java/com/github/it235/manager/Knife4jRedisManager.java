package com.github.it235.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: jianjun.ren
 * @date: Created in 2020/9/27 14:32
 */

public class Knife4jRedisManager {

    private Map<String, RedisTemplate> redisTemplateMap;

    private Map<String, StringRedisTemplate> stringRedisTemplateMap;

    public Knife4jRedisManager(Map<String, RedisTemplate> redisTemplateMap ,
                               Map<String, StringRedisTemplate> stringRedisTemplateMap) {
        this.redisTemplateMap = redisTemplateMap;
        this.stringRedisTemplateMap = stringRedisTemplateMap;
    }

    public RedisTemplate redisTemplate(int dbIndex) {
        RedisTemplate redisTemplate = redisTemplateMap.get("redisTemplate" + dbIndex);
        /*redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);*/
        return redisTemplate;
    }

    public StringRedisTemplate stringRedisTemplate(int dbIndex) {
        StringRedisTemplate stringRedisTemplate = stringRedisTemplateMap.get("stringRedisTemplate" + dbIndex);
        stringRedisTemplate.setEnableTransactionSupport(true);
        return stringRedisTemplate;
    }

    public Map<String, RedisTemplate> getRedisTemplateMap() {
        return redisTemplateMap;
    }

    public Map<String, StringRedisTemplate> getStringRedisTemplateMap() {
        return stringRedisTemplateMap;
    }
}
