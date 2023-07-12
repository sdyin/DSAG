package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.*;

/**
 * @Description: leetcode 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * @Author: liuye
 * @time: 2023/7/12$ 9:18 下午$
 */
public class MaxSlidingWindow_239 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        MonotonicQueue window = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k-1) {
                // 先填满窗口的前k-1个元素
                window.push(nums[i]);
            } else {
                // 窗口向右移动，加入新元素
                window.push(nums[i]);

                // 符合窗口大小，加入当前窗口最大值
                list.add(window.max());

                // 移除最左元素
                window.pop(nums[i + 1 - k]);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}

/**
 * 单调队列：队列中的元素单调递增或递减
 */
class MonotonicQueue {

    // 核心数据结构: 双向链表
    private Deque<Integer> data = new LinkedList<>();

    // 添加元素
    public void push(int n) {
        // 队列不为空且队尾元素小于当前元素，则移除队尾元素，也就是保证了队头到队尾是单调递减的
        // 之所以要保留队头到队尾单调递减，保留多个元素，而不是一个元素, 是因为最大的元素可能会被移除，移除后仍然需要窗口内最大元素，所以不能只保存一个元素
        while (!data.isEmpty() && data.peekLast() < n) {
            data.pollLast();
        }
        // 添加元素到队尾
        data.offerLast(n);
    }

    // 获取最大元素
    public int max() {
        //实际上就是获取队头元素
        return data.peekFirst();
    }

    // 删除元素
    public void pop(int n) {
        // 如果队头元素等于当前元素，则移除队头元素
        // 因为队头元素一定比后面元素早入队，所以不用担心会漏移除队头元素后续的元素。(这里完全匹配单调队列的特性)
        if (!data.isEmpty() && data.peekFirst() == n) {
            data.pollFirst();
        }
    }
}