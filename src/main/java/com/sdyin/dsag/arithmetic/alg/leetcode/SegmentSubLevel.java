package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * TODO 待梳理逻辑
 * @Description 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @Author liuye
 * @Date 2020/10/11 15:28
 **/
public class SegmentSubLevel {

    public boolean canPartition(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        int data = sum % 2;
        if(data != 0){
            return false;
        }
        int target =  sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[length][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // 再填表格后面几行
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[length - 1][target];
    }
}
