package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: 2462. 雇佣 K 位工人的总代价
 * 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。
 * 同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：
 *
 * 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
 * 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
 * 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
 * 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 一位工人只能被选择一次。
 * 返回雇佣恰好 k 位工人的总代价。
 * @Author: liuye
 * @time: 2023/9/18$ 5:12 下午$
 */
public class TotalCost_2462 {

    // 优先队列
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>();
        int len = costs.length;
        int left = 0;
        int right = len - 1;
        // 左右优先队列添加节点
        for (int i = 0; i < candidates; i++) {
            priorityQueue1.add(costs[left++]);
            if (left > right) {
                break;
            }
            priorityQueue2.add(costs[right--]);
            if (left > right) {
                break;
            }
        }
        long res = 0L;

        //k次取数循环
        for (int i = 0; i < k; i++) {
            if (priorityQueue1.isEmpty()) {
                res += priorityQueue2.poll();
            } else if (priorityQueue2.isEmpty()) {
                res += priorityQueue1.poll();
            } else {
                int tem1 = priorityQueue1.peek();
                int tem2 = priorityQueue2.peek();
                if (tem1 > tem2) {
                    res += priorityQueue2.poll();
                    //命中移除掉一个元素后，需要再补充取数
                    if (right >= left) {
                        priorityQueue2.add(costs[right--]);
                    }
                } else {
                    res += priorityQueue1.poll();
                    if (right >= left) {
                        priorityQueue1.add(costs[left++]);
                    }
                }
            }
        }
        return res;
    }
}
