package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 48. 旋转图像
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *

 * @Author: liuye
 * @time: 2022/4/8$ 5:33 下午$
 */
public class Rotate48 {

    /**
     * 顺时针旋转90度,等效于
     * 1.先按对角线反转，(1,4) -> (4,1)
     * 2.再翻转每行，(1,1) -> (1,4)，(1,1) -> (1,4)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //先按对角线折叠 (i,j) -> (j,i)
        for (int i = 0; i < length; i++) {
            //翻转半部分即可，所以j=i；
            for (int j = i; j < matrix[0].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //再每行翻转
        for (int i = 0; i < length; i++) {
            //折叠一半即可，所以除以2
            for (int j = 0; j < matrix[0].length/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][length -1-j];
                matrix[i][length-1-j] = tmp;
            }
        }
    }
}
