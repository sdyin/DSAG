package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 * @Author: liuye
 * @time: 2021/3/16$ 下午3:10$
 */
public class GenerateMatrix59 {

    public static int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, up = 0, down = n - 1;
        int[][] mat = new int[n][n];
        int num = 1;
        int target = n * n;
        while (num <= target){
            for (int i = left; i <= right; i++) {
                //赋值
                mat[up][i] = num++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                mat[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                mat[down][i] = num++;
            }
            down--;
            for (int i = down; i >= up; i--) {
                mat[i][left] = num++;
            }
            left++;
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] arr = generateMatrix(3);
        int length = arr.length;
        int width =  arr[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println(arr[i][j]);
            }
        }

    }
}
