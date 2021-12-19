package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 766.托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 * @Author: liuye
 * @time: 2021/2/22$ 上午10:07$
 */
public class IsToeplitzMatrix766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int high = matrix.length;
        int length = matrix[0].length;
        for (int i = 0; i < high - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if(matrix[i][j] != matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }
}
