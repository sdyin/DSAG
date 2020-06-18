package com.sdyin.dsag.arithmetic.alg.dp;

/**
 * @Description 求不同路径走法之和
 * m * n(m行n列) 假设网格中有障碍物，需排除障碍物走法，障碍物为1 空位置为0
 * @Author liuye
 * @Date 2020/6/18 20:09
 **/
public class DifferentPath2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;

        for (int i = 1; i < m; i++) {
            //当前节点为0 且 上一节点为1(上一节点值已更新为走法之和)
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i -1][0] ==1) ? 1:0;
        }

        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] ==1) ? 1:0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    //有障碍物节点永远达不到，所以为0
                    obstacleGrid[i][j] = 0;
                }else{
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        DifferentPath2 diff = new DifferentPath2();
        int[][] arr = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int i = diff.uniquePathsWithObstacles(arr);
        System.out.println("走法总和为：" + i);
    }
}
