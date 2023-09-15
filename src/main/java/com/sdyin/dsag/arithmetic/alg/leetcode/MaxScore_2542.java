package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: 2542. 最大子序列的分数
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都是 n ，再给你一个正整数 k 。
 * 你必须从 nums1 中选一个长度为 k 的 子序列 对应的下标。
 * 对于选择的下标 i0 ，i1 ，...， ik - 1 ，你的 分数 定义如下：
 * <p>
 * nums1 中下标对应元素求和，乘以 nums2 中下标对应元素的 最小值 。
 * 用公式表示： (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]) 。
 * 请你返回 最大 可能的分数。
 * <p>
 * 一个数组的 子序列 下标是集合 {0, 1, ..., n-1} 中删除若干元素得到的剩余集合，也可以不删除任何元素。
 * @Author: liuye
 * @time: 2023/9/15$ 1:48 下午$
 */
public class MaxScore_2542 {

    /**
     *  排序 + 优先队列解法
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long ans = 0L;
        // 按照nums2 降序排序，用sorts保存索引下标的排序规则
        Integer[] sorts = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorts[i] = i;
        }
        Arrays.sort(sorts, (a, b) -> nums2[b] - nums2[a]);

        //
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0L;
        // 索引下标小于k-1 时，累加nums1的值
        for (int i = 0; i < k - 1; i++) {
            sum += nums1[sorts[i]];
            pq.offer(nums1[sorts[i]]);
        }
        // 索引下标大于等于k-1时，对nums1添加右侧节点，移除优先队列的最小节点
        // 因为按照nums2降序排序，所以nusm2的最小值肯定是逐渐变小且是索引i，所以每次移除nums1中最小节点的值。
        for (int i = k - 1; i < n; i++) {
            sum += nums1[sorts[i]];
            pq.offer(nums1[sorts[i]]);
            ans = Math.max(ans, nums2[sorts[i]] * sum);
            sum -= pq.poll();
        }

        return ans;
    }
}
