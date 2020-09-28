package com.github.it235.props;

/**
 * @description:
 * @author: jianjun.ren
 * @date: Created in 2020/9/28 11:10
 */
public enum JsonSerialType {
    /**
     * springboot自带的jackson序列化方式，本工具默认的方式
     * redis中存储时会带@package标志，若多服务调用时package不一样可能会出现反序列化失败的情况
     */
    Jackson,
    /**
     * 可在yml中指定开启，采用alibaba.fastjson
     * redis中存储时不会带@package标志，多服务的情况下存取较友好
     * 因为没有package描述符，实际是走的字符串转换，效率略低一些
     */
    Fastjson,
    ;
}
