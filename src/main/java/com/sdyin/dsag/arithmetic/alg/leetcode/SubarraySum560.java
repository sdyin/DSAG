package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 注意了：求子数组的个数，子数组那说明肯定是数组中连续的元素了。
 * @Author: liuye
 * @time: 2022/4/6$ 11:02 下午$
 */
public class SubarraySum560 {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //先求出前缀和
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] =  preSum[i-1] + nums[i-1];
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
