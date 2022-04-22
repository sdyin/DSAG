package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;

/**
 * @Description: 322.零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * @Author: liuye
 * @time: 2022/4/22$ 10:18 下午$
 */
public class CoinChange322 {

    //备忘录优化：自顶向下 场景优化手段
    static int[] memo;

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        //金额从0开始，即初始数组长度加1
        memo = new int[amount + 1];
        //初始化数组
        Arrays.fill(memo, -100);
        return dp(coins, amount);
    }

    /**
     * dp：自顶向下，所以是递归的方式
     *
     * @param coins  硬币数组
     * @param amount 金额
     * @return 所需数量
     */
    private static int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        if (memo[amount] != -100) {
            return memo[amount];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            //状态转移方程：子问题的数量
            int quantity = 1 + dp(coins, amount - coins[i]);
            // 无匹配的值时，跳过
            if (quantity == 0) {
                continue;
            }
            min = Math.min(min, quantity);
        }
        //计算出数值后添加到备忘录
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 1;
        final int i = coinChange(coins, amount);
        System.out.println(i);
    }


}
