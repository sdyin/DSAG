package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 790. 多米诺和托米诺平铺
 *
 * 有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 *
 * 给定整数 n，返回可以平铺 2 x n 的面板的方法的数量。返回对 10的9次方 + 7 取模 的值。
 *
 * 平铺指的是每个正方形都必须有瓷砖覆盖。
 * 两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。
 *
 * 示例 1:
 * 输入: n = 3
 * 输出: 5
 * 解释: 五种不同的方法如上所示。
 *
 * 示例 2:
 * 输入: n = 1
 * 输出: 1
 *
 * 提示：
 * 1 <= n <= 1000
 *
 * @Author: liuye
 * @time: 2023/12/6$ 4:01 下午$
 */
public class NumTilings_790 {

    /**
     * 根据题意，参数为n, 则平铺的高度为2，宽度为n
     *  1.当n=1时，只有一种平铺方式
     *  2.当n=2时，有两种平铺方式：两个多米诺形横竖两种方式
     * @param n
     * @return
     */
    public int numTilings(int n) {
        final int MOD = 1000000007;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        // 初始值
        // dp[0] 代表无需铺设，也是一种方式
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // 状态转移方程: TODO: 为什么是这个方程
            dp[i] = (int) ((2L * dp[i - 1] + dp[i - 3]) % MOD);
        }
        return dp[n];
    }
}
