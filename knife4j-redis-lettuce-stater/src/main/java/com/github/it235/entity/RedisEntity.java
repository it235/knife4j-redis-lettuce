package com.github.it235.entity;


import com.github.it235.props.JsonSerialType;

import java.time.Duration;
import java.util.List;

/**
 * @description:
 * @author: jianjun.ren
 * @date: Created in 2020/9/27 16:03
 */
public class RedisEntity {
    private JsonSerialType jsonSerialType;
    private String host;
    private Integer port;
    private String password;
    private List<Integer> databases;
    private Duration timeout;
    private LettuceEnity lettuce;

    public JsonSerialType getJsonSerialType() {
        return jsonSerialType;
    }

    public void setJsonSerialType(JsonSerialType jsonSerialType) {
        this.jsonSerialType = jsonSerialType;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getDatabases() {
        return databases;
    }

    public void setDatabases(List<Integer> databases) {
        this.databases = databases;
    }

    public Duration getTimeout() {
        return timeout;
    }

    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
    }

    public LettuceEnity getLettuce() {
        return lettuce;
    }

    public void setLettuce(LettuceEnity lettuce) {
        this.lettuce = lettuce;
    }
}
