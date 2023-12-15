package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 72. 编辑距离
 * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 示例1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * @Author: liuye
 * @time: 2022/4/25$ 7:41 上午$
 */
public class MinDistance_72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //定义dp: dp[i+1][j+1] 二维数组对应的 word1[i]word2[j] 的最小编辑距离
        int[][] dp = new int[m+1][n+1];

        //base case: 如果m = 0,dp[0][j] 等于 n的长度
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n ; j++) {
            dp[0][j] = j;
        }

        //dp 二维数组自底向上求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 状态转移方程：
                //如果索引i处 和 j处相等,相当于移除当前这两个字符，和前面子串一样
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //如果两个字符串对应的索引i 和 索引j不相等，则只能比较删除，替换，插入三种操作，另外要注意操作数要+1
                    //参数依次代表 删除(i往前移一位，j不动)，替换(i 和 j匹配，i,j都前移)，插入(i不动，j前移一位)
                    dp[i][j] = min(dp[i-1][j] + 1, dp[i-1][j-1] + 1, dp[i][j-1] + 1);
                }
            }

        }
        return dp[m][n];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
