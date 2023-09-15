package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.PriorityQueue;

/**
 * @Description: 2336. 无限集中的最小数字
 * 现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。
 * 实现 SmallestInfiniteSet 类：
 *
 * SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
 * int popSmallest() 移除 并返回该无限集中的最小整数。
 * void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集中。
 *
 * 提示：
 * 1 <= num <= 1000
 * 最多调用 popSmallest 和 addBack 方法 共计 1000 次
 *
 * @Author: liuye
 * @time: 2023/9/15$ 11:45 上午$
 */
public class SmallestInfiniteSet_2336 {

    // 默认小跟堆
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue();

    public SmallestInfiniteSet_2336() {
        for (int i = 1; i <= 1000; i++) {
            priorityQueue.offer(i);
        }
    }

    public int popSmallest() {
        return priorityQueue.poll();
    }

    public void addBack(int num) {
        if (!priorityQueue.contains(num)) {
            priorityQueue.offer(num);
        }
    }
}
