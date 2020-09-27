package com.github.it235.entity;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

/**
 * @description:
 * @author: jianjun.ren
 * @date: Created in 2020/9/27 16:21
 */
public class LettuceEnity extends RedisProperties.Lettuce {
    private PoolEntity poolEntity;

    public PoolEntity getPoolEntity() {
        return poolEntity;
    }

    public void setPoolEntity(PoolEntity poolEntity) {
        this.poolEntity = poolEntity;
    }
}
