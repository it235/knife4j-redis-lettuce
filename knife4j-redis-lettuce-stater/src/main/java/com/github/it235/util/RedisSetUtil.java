package com.github.it235.util;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: jianjun.ren
 * @date: Created in 2020/9/28 11:36
 */
@ConditionalOnBean(RedisBaseUtil.class)
public class RedisSetUtil extends RedisBaseUtil{

    /**
     * 向set中添加元素
     * @param key  需要操作的key
     * @param values 返回添加的个数
     * @return
     */
    public Long add(String key, Object ... values) {
        return add(defaultDB , key ,values);
    }
    public Long add(int dbIndex ,String key, Object ... values) {
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().add(key, values);
    }

    /**
     * 获取set的size大小
     * @param key 键
     * @return
     */
    public Long size(String key) {
        return size(defaultDB , key);
    }
    public Long size(int dbIndex ,String key) {
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().size(key);
    }

    /**
     * 判断 member 元素是否是集合 key 的成员
     * @param key  需要操作的key
     * @param member 待确认的元素
     * @return
     */
    public Boolean hasMember(String key , Object member){
        return hasMember(defaultDB ,key ,member);
    }
    public Boolean hasMember(int dbIndex ,String key , Object member){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().isMember(key , member);
    }

    /**
     * 返回集合中的所有成员
     * @param key
     * @return
     */
    public Set<Object> getAll(String key){
        return getAll(defaultDB ,key);
    }
    public Set<Object> getAll(int dbIndex ,String key){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().members(key);
    }

    /**
     * 随机获取key无序集合中的一个元素
     * @param key
     * @return
     */
    public Object randomMember(String key){
        return randomMember(defaultDB , key);
    }
    public Object randomMember(int dbIndex ,String key){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().randomMember(key);
    }

    /**
     * 随机获取多个无序集合中的元素
     * @param key
     * @param count 获取的个数
     * @return
     */
    public List<Object> randomMembers(String key, long count){
        return randomMembers(defaultDB ,key ,count);
    }
    public List<Object> randomMembers(int dbIndex ,String key, long count){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().randomMembers(key , count);
    }

    /**
     * 随机获取多个无序集合中的元素（去重）
     * @param key
     * @param count 获取的个数
     * @return
     */
    public Set<Object> distinctRandomMembers(String key, long count){
        return distinctRandomMembers(defaultDB , key ,count);
    }
    public Set<Object> distinctRandomMembers(int dbIndex ,String key, long count){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().distinctRandomMembers(key , count);
    }

    /**
     * 遍历set
     * @param key
     * @return
     */
    public Cursor<Object> scan(String key){
        return scan(defaultDB ,key);
    }
    public Cursor<Object> scan(int dbIndex , String key){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().scan(key , ScanOptions.NONE);
        /*
            while(curosr.hasNext()){
                System.out.println(curosr.next());
            }
         */
    }

    /**
     * 移除集合中一个或多个成员
     * @param key
     * @param values
     * @return
     */
    public Long remove(String key, Object... values){
        return remove(defaultDB , key , values);
    }
    public Long remove(int dbIndex ,String key, Object... values){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().remove(key ,values);
    }

    /**
     * 将 member 元素从 source 集合移动到 destination 集合
     * @param key
     * @param value
     * @param destKey
     * @return
     */
    public Boolean move(String key, Object value, String destKey){
        return move(defaultDB , key ,value ,destKey);
    }
    public Boolean move(int dbIndex ,String key, Object value, String destKey){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().move(key ,value , destKey);
    }

    /**
     * 交集：返回2个集合的交集
     * @param key
     * @param otherKey
     * @return
     */
    public Set<Object> intersect(String key, String otherKey){
        return intersect(defaultDB , key , otherKey);
    }
    public Set<Object> intersect(int dbIndex ,String key, String otherKey){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().intersect(key , otherKey);
    }

    /**
     * 交集：返回1个key和其他多个key的交集
     * @param key
     * @param otherKeys
     * @return
     */
    public Set<Object> intersect(String key, Collection<String> otherKeys){
        return intersect(defaultDB , key , otherKeys);
    }
    public Set<Object> intersect(int dbIndex ,String key, Collection<String> otherKeys){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().intersect(key , otherKeys);
    }

    /**
     * 交集：key无序集合与otherkey无序集合的交集存储到destKey无序集合中
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public Long intersectAndStore(String key, String otherKey, String destKey){
        return intersectAndStore(defaultDB , key ,otherKey ,destKey);
    }
    public Long intersectAndStore(int dbIndex ,String key, String otherKey, String destKey){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().intersectAndStore(key , otherKey , destKey);
    }

    /**
     * 交集：key对应的无序集合与多个otherKey对应的无序集合求交集存储到destKey无序集合中
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public Long intersectAndStore(String key, Collection<String> otherKeys, String destKey){
        return intersectAndStore(defaultDB ,key , otherKeys ,destKey);
    }
    public Long intersectAndStore(int dbIndex ,String key, Collection<String> otherKeys, String destKey){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().intersectAndStore(key , otherKeys , destKey);
    }

    /**
     * 并集：key无序集合与otherKey无序集合的并集
     * @param key
     * @param otherKey
     * @return
     */
    public Set<Object> union(String key, String otherKey){
        return union(defaultDB ,key ,otherKey);
    }
    public Set<Object> union(int dbIndex ,String key, String otherKey){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().union(key , otherKey);
    }

    /**
     * 并集：key无序集合与多个otherKey无序集合的并集
     * @param key
     * @param otherKeys
     * @return
     */
    public Set<Object> union(String key, Collection<String> otherKeys){
        return union(defaultDB , key , otherKeys);
    }
    public Set<Object> union(int dbIndex ,String key, Collection<String> otherKeys){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().union(key , otherKeys);
    }

    /**
     * 并集：key无序集合与otherkey无序集合的并集存储到destKey无序集合中
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public Long unionAndStore(String key, String otherKey, String destKey){
        return unionAndStore(defaultDB , key , otherKey , destKey);
    }
    public Long unionAndStore(int dbIndex ,String key, String otherKey, String destKey){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().unionAndStore(key , otherKey , destKey);
    }

    /**
     * 并集：key无序集合与多个otherkey无序集合的并集存储到destKey无序集合中
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public Long unionAndStore(String key, Collection<String> otherKeys, String destKey){
        return unionAndStore(defaultDB , key , otherKeys , destKey);
    }
    public Long unionAndStore(int dbIndex ,String key, Collection<String> otherKeys, String destKey){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().unionAndStore(key , otherKeys , destKey);
    }

    /**
     * 差集：key无序集合与otherKey无序集合的差集
     * @param key
     * @param otherKey
     * @return
     */
    public Set<Object> difference(String key, String otherKey){
        return difference(defaultDB ,key ,otherKey);
    }
    public Set<Object> difference(int dbIndex ,String key, String otherKey){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().difference(key , otherKey);
    }

    /**
     * 差集：key无序集合与多个otherKey无序集合的差集
     * @param key
     * @param otherKeys
     * @return
     */
    public Set<Object> difference(String key, Collection<String> otherKeys){
        return difference(defaultDB , key , otherKeys);

    }
    public Set<Object> difference(int dbIndex ,String key, Collection<String> otherKeys){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().difference(key , otherKeys);
    }

    /**
     * 差集：key无序集合与otherkey无序集合的差集存储到destKey无序集合中
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public Long differenceAndStore(String key, String otherKey, String destKey){
        return differenceAndStore(defaultDB , key , otherKey , destKey);
    }
    public Long differenceAndStore(int dbIndex ,String key, String otherKey, String destKey){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().differenceAndStore(key , otherKey , destKey);
    }

    /**
     * 差集：key无序集合与多个otherkey无序集合的差集存储到destKey无序集合中
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public Long differenceAndStore(String key, Collection<String> otherKeys, String destKey){
        return differenceAndStore(defaultDB , key , otherKeys , destKey);
    }
    public Long differenceAndStore(int dbIndex ,String key, Collection<String> otherKeys, String destKey){
        return knife4jRedisManager.redisTemplate(dbIndex).opsForSet().differenceAndStore(key , otherKeys , destKey);
    }
}