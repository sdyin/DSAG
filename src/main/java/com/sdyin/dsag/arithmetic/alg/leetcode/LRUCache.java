package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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

    private Map<Integer, Integer> map = new HashMap();

    private Deque deque = new LinkedList();

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
        if(map.get(key) == null){
            return -1;
        }
        deque.remove(key);
        deque.offerFirst(key);
        return map.get(key);
    }

    /**
     * put设值:考虑超过容量时剔除最久的值
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        //存在值
        if(map.get(key) != null){
            map.put(key,value);
            //设值新值时,当前key也应该是最新的
            deque.remove(key);
            deque.offerFirst(key);
        }else{
            //不存在值
            //容量已满
            if(map.size() == capacity){
                //先移除最久的值
                int k = (int) deque.pollLast();
                map.remove(k);

                //再添加最新的值
                map.put(key, value);
                deque.offerFirst(key);
            }else{
                map.put(key,value);
                deque.offerFirst(key);
            }
        }
    }
}
