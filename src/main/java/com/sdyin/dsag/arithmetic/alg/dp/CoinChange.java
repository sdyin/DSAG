package com.sdyin.dsag.arithmetic.alg.dp;

import java.util.Arrays;

/**
 * @Description:
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，
 * 再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
 * @Author: liuye
 * @time: 2020/7/22$ 下午8:44$
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {2,5};
        int amount = 33;
        int result = coinChange(coins, amount);
        System.out.println("结果："+ result);
    }

    /**
     * 迭代解法 -》 自底向上
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1 -> 方便后续Math.min
        Arrays.fill(dp, amount + 1);
        //dp[i] 的值表示数额为i时，最小的硬币数量
        // base case
        dp[0] = 0;
        // 遍历所有场景
        for (int i = 0; i < dp.length; i++) {
            //所有场景的取值
            for (int coin: coins){
                // 子问题无解，跳过 -> 最小coins都大于目标amount场景
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                System.out.println("dp[i]:" + i + " result:" + dp[i]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
