package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.*;

/**
 * @Description: 146. LRU 缓存
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；
 * 如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/4/13$ 9:16 上午$
 */
public class LRUCache146 {

    int capacity = 0;
    //新访问的元素放在队头，容量满了后从队尾移除元素
    LinkedList<Integer> list = new LinkedList<>();;
    //存放目标key-value
    Map<Integer, Integer> map = new HashMap<>();

    public LRUCache146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //双向链表删除元素时，只需要断开该节点,移除该节点，可以O(1)
        // (这里有个小的问题，使用key数值，在构造链表node节点时，其实还是o(N), 除非map直接存node节点)
        list.remove((Object)key);
        list.addFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        //包含元素
        if (map.containsKey(key)) {
            map.put(key, value);
            //之所以转为Object，是linkedlist 有几个重载方法，防止走错方法
            list.remove((Object)key);
            list.addFirst(key);
        } else {
            //不包含元素

            //容量未满
            if(map.size() < capacity){
                map.put(key, value);
                list.addFirst(key);
            } else {
                //容量已满
                final Integer lastIndexKey = list.removeLast();
                map.remove(lastIndexKey);
                list.addFirst(key);
                map.put(key, value);
            }
        }

    }
}
