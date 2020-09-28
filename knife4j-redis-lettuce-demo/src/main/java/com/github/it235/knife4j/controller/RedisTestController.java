package com.github.it235.knife4j.controller;

import com.github.it235.util.RedisHashUtil;
import com.github.it235.util.RedisListUtil;
import com.github.it235.util.RedisSetUtil;
import com.github.it235.util.RedisValUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description: redis测试接口类
 * @author: jianjun.ren
 * @date: Created in 2020/9/27 23:40
 */
@RestController
@RequestMapping("/test")
public class RedisTestController {

    @Autowired
    private RedisValUtil redisValUtil;

    /**
     * 单值操作测试
     * @param key
     * @return
     */
    @GetMapping("/val/{key}")
    public String test(@PathVariable("key") String key){
        redisValUtil.set(key , "默认库设置");
        redisValUtil.set(1 , key , "指定1库设置值");

        //get值
        String db1SetKey = redisValUtil.get(1, key);
        System.out.println("指定1库获取值：" + db1SetKey);

        //删除后再get
        redisValUtil.delete(1 , key);
        String db1SetKey2 = redisValUtil.get(1, key);
        System.out.println("指定1库获取已经被删除的值：" + db1SetKey2);

        return "ok";
    }


    @Autowired
    private RedisListUtil redisListUtil;

    /**
     * 集合操作测试
     * @param key
     * @return
     */
    @GetMapping("/list/{key}")
    public String listTest(@PathVariable("key") String key){
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("深入理解JVM（第三版）");
        Book book2 = new Book();
        book2.setId(2);
        book2.setName("SpringBoot从实战到精通");
        Book [] array = new Book[]{book1 , book2};
        redisListUtil.insert(3 , key , array);
        List<Book> listAll = redisListUtil.getListAll(3, key, Book.class);
        System.out.println("redis库中取出的值：" + listAll);

        return "ok";
    }


    @Autowired
    private RedisHashUtil redisHashUtil;
    /**
     * hash操作测试
     * @param key
     * @return
     */
    @GetMapping("/hash/{key}")
    public String hashTest(@PathVariable("key") String key){
        Map<String,Book> map = new HashMap<>();
        Book book1 = new Book();
        book1.setId(4);
        book1.setName("深入理解JVM（第二版）");
        Book book2 = new Book();
        book2.setId(5);
        book2.setName("redis从实战到精通");
        map.put("A" , book1);
        map.put("B" , book2);
        redisHashUtil.addMapAll(5 , key , map);
        Map<String, Book> mapAll = redisHashUtil.getMapAll(5 , key, String.class, Book.class);
        System.out.println("从redis中取出Map的值：" + mapAll);

        //往第6库添加Hash
        redisHashUtil.addMapOne(6 , key , "W" , book1);
        Long w = redisHashUtil.deleteMapVal(6, key, "W");
        System.out.println("删除hash条数：" + w);
        return "ok";
    }


    @Autowired
    private RedisSetUtil redisSetUtil;

    /**
     * 集合操作测试
     * @param key
     * @return
     */
    @GetMapping("/set/{key}")
    public String setTest(@PathVariable("key") String key){
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("深入理解JVM（第三版）");
        Book book2 = new Book();
        book2.setId(2);
        book2.setName("SpringBoot从实战到精通");
        Book [] array = new Book[]{book1 , book2};
        redisSetUtil.add(3 , key , array);
        Set<Object> setAll = redisSetUtil.getAll(3, key);
        System.out.println("redis库中取出的值：" + setAll);
        return "ok";
    }

}

@Getter
@Setter
@ToString
class Book implements Serializable {
    private int id;
    private String name;

}