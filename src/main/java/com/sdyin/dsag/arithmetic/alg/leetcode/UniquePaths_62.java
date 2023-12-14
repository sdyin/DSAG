package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 *
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 *
 * @Author: liuye
 * @time: 2023/12/13$ 5:18 下午$
 */
public class UniquePaths_62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //初始化第一行
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //初始化第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        //从第二行第二列开始
        for (int i = 1; i < m; i++) {
            for (int j = 1; j< n; j++) {
                //状态转移方程
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        //下标索引从0开始，所以m-1,n-1
        return dp[m-1][n-1];
    }
}
