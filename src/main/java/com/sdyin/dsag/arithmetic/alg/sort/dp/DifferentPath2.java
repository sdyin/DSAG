package com.sdyin.dsag.arithmetic.alg.sort.dp;

import javax.crypto.spec.OAEPParameterSpec;

/**
 * @Description 求不同路径走法之和
 *  m * n(m行n列) 假设网格中有障碍物，需排除障碍物走法，障碍物为1 空位置为0
 * @Author liuye
 * @Date 2020/6/18 20:09
 **/
public class DifferentPath2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for (int i = 0; i < m; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        DifferentPath2 diff = new DifferentPath2();
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        int i = diff.uniquePathsWithObstacles(arr);
        System.out.println("走法总和为：" + i);
    }
}
