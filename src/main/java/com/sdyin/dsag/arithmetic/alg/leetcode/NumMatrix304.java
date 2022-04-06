package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 304.二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1,col1) ，右下角 为 (row2,col2) 。
 *
 * 实现 NumMatrix 类：
 * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2)返回 左上角 (row1,col1)、右下角(row2,col2) 所描述的子矩阵的元素 总和 。
 *
 * @Author: liuye
 * @time: 2022/4/6$ 8:58 下午$
 */
public class NumMatrix304 {

    // pre[i][j] 记录的是矩阵[0,0,i-1,j-1]的 元素和。
    private int[][] preSum;

    public NumMatrix304(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        //构造前缀和的矩阵
        preSum = new int[x + 1][y + 1];
        if ( x == 0 || y == 0) {
            return;
        }
        for (int i = 1; i < x+1; i++) {
            for (int j = 1; j < y+1; j++) {
                //计算矩阵 [0,0,x,y] 的元素和
                preSum[i][j] = preSum[i-1][j]  + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //这里是关键思路,注意 preSum[row2+1][col2+1] 表示的是 sumRegion(0,0,row2,col2)
        return preSum[row2+1][col2+1] - preSum[row2+1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
    }

}
