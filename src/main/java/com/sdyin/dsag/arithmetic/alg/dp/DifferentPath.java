package com.sdyin.dsag.arithmetic.alg.dp;

/**
 * @Description  求不同路径之和
 * m * n (m行n列)的表格,从左上角到右下角有多少种走法？(只能向右和向下)
 * @Author liuye
 * @Date 2020/6/18 17:15
 **/
public class DifferentPath {


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //i,j 从1开始，因为下标为0处不需要计算
        //自底向上 因为顶部值为初始值，只能由底部递推到顶部
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        DifferentPath differentPath = new DifferentPath();
        int m = 2;
        int n = 3;
        int i = differentPath.uniquePaths(m, n);
        System.out.println(m + "*" + n + "走法之和为：" + i);
    }
}
