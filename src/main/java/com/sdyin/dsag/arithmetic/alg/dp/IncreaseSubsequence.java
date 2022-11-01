package com.sdyin.dsag.arithmetic.alg.dp;

import java.util.Arrays;

/**
 * @Description: 最长递增子序列
 * @Author: liuye
 * @time: 2022/11/1$ 5:21 下午$
 */
public class IncreaseSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // dp[i] 表示以 nums[i] 这个数结尾(注意理解)的最长递增子序列的长度。
        // 疑问：为什么dp[i] 一定要是以i这个索引结尾？
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        //base case, 下标对应数据具体下标索引
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,54,4,67,99,22,8,9};
        int length = lengthOfLIS(arr);
        System.out.println(length);
    }

}
