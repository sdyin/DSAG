package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.*;

/**
 * @Description: leetcode 146
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 * @Author: liuye
 * @time: 2021/4/13$ 下午5:48$
 */
public class LRUCache {

    private int capacity;

    // 双向链表 + 哈希表
    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();

    public LRUCache(){}

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 获取值：考虑最新获取的值放到最前面
     * @param key
     * @return
     */
    public int get(int key) {
        if(cache.get(key) == null){
            return -1;
        }
        Integer value = cache.get(key);
        // 删除原有key 重新插入，重新插入为插入链表尾部
        cache.remove(key);
        cache.put(key, value);
        return cache.get(key);
    }

    /**
     * put设值:考虑超过容量时剔除最久的值
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        //存在值
        if(cache.get(key) != null){
            cache.put(key,value);
            //设值新值时,当前key也应该是最新的
            //删除原有key 重新插入
            cache.remove(key);
            cache.put(key, value);
        }else{
            //不存在值
            //容量已满
            if(cache.size() == capacity){
                //先移除最久的值(也就是最先存入的值)
                Map.Entry<Integer, Integer> next = cache.entrySet().iterator().next();
                cache.remove(next.getKey());

                //再添加最新的值
                cache.put(key, value);
            }else{
                cache.put(key,value);
            }
        }
    }
}
