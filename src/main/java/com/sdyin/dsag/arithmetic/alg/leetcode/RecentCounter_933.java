package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * @Description: 933. 最近的请求次数
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 * 请你实现 RecentCounter 类：
 *
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 * @Author: liuye
 * @time: 2023/9/7$ 7:23 下午$
 */
public class RecentCounter_933 {

    private Queue<Integer> queue;

    public RecentCounter_933() {
        queue = new ArrayDeque<Integer>();
    }

    /**
     * 队列先进先出特性，且队列中的元素是按照时间顺序排列的，所以只需要判断队列中的头元素是否在t-3000范围，不存在则移除
     * @param t
     * @return
     */
    public int ping(int t) {
        int value = t - 3000;
        queue.add(t);
        while(queue.peek() < value){
            queue.poll();
        }
        return queue.size();
    }
}
