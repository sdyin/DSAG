package com.sdyin.dsag.arithmetic.alg.leetcode;

import org.springframework.cache.Cache;

import java.util.LinkedHashMap;

/**
 * @Description:
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
 * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * @Author: liuye
 * @time: 2023/8/9$ 1:40 下午$
 */
public class LRUCache_146_2 {

    private int capacity;

    // hashmap + 双向链表
    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache_146_2(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            //重写removeEldestEntry方法，当map中元素多余capacity时，删除最久未使用的元素
            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
                return cache.size() > capacity;
            }
        };
    }

    /**
     * 获取元素
     * @param key
     * @return
     */
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
