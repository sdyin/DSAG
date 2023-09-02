package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * @Author: liuye
 * @time: 2023/9/2$ 3:59 下午$
 */
public class FindMaxAverage_643 {

    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];
            // 当索引下标达到k-1时，窗口满足，开始计算最大值
            // 窗口大小还没满足时，不要计算最大值，元素可能有负数，可能导致结果偏大
            if (i >= k - 1) {
                max = Math.max(max, sum);
                sum = sum - nums[i - k + 1];
            }
        }
        return max * 1.0 / k;
    }
}
