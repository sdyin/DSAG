package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 460
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * 实现 LFUCache 类：
 *
 * LFUCache(int capacity) - 用数据结构的容量capacity 初始化对象
 * int get(int key)- 如果键存在于缓存中，则获取键的值，否则返回 -1。
 * void put(int key, int value)- 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
 *
 * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 *
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 *
 *
 * @Author: liuye
 * @time: 2021/4/14$ 下午2:33$
 */
public class LFUCache {

    private int capacity;

    public LFUCache(int capacity) {

    }

    public int get(int key) {

        return 0;
    }

    public void put(int key, int value) {

    }
}
