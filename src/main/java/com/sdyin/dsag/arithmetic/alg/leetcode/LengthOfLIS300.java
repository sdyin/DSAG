package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;

/**
 * @Description: 300. 最长递增子序列
 *给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * @Author: liuye
 * @time: 2022/4/23$ 5:14 下午$
 */
public class LengthOfLIS300 {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        final int length = lengthOfLIS(nums);
        System.out.println(length);
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //初始化，每个元素最小递增子序列是1
        Arrays.fill(dp, 1);
        //base case
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            //计算每个节点之前比自己小的元素总和
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //这里非常重要，因为nums[i] > nums[j], 所以dp[i] 比 dp[j] 最少大1.
                    //我们不能只判断 num[i] 和 num[i-1] 因为数组无序，num[i] > num[i-1] 不一定就代表 dp[i] = dp[i-1] + 1。
                    //比如 nums = [10,9,2,5,1,7,101,18], 7>1 但是实际上最终dp[5] > dp[4] + 1
                    //所以我们得让num[i] 和 nums[0] 到 num[i-1] 依次比较
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] < dp[i-1]) {
                dp[i] = dp[i-1];
            }
        }
        return dp[nums.length - 1];
    }
}
