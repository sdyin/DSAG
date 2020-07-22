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

    public static int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        //初始化值,初始化一个最大可能值+1，最终不存在则为此值 不会更新
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++){
            for (int coin: coins) {
                //无解
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
            System.out.println(i + ":" + dp[i]);
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
