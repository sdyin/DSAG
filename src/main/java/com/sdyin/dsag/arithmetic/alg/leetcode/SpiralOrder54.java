package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @Author: liuye
 * @time: 2022/4/8$ 8:44 下午$
 */
public class SpiralOrder54 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        final List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> list = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        //索引位，所以减一
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        while (list.size() < m * n) {
            //最上排：从左往右
            //为什么是小于等于 而不是小于？比如up为0时，第一行添加完。这时up就变为1，但此时下标为1的行仍未标记
            if (up <= down) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[up][i]);
                }
                ++up;
            }
            //最右侧：从上往下
            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    list.add(matrix[i][right]);
                }
                --right;
            }
            //最下排：从右往左
            if (up <= down){
                for (int i = right; i >= left ; i--) {
                    list.add(matrix[down][i]);
                }
                --down;
            }
            //最左侧: 从下往上
            if (left <= right) {
                for (int i = down; i >= up ; i--) {
                    list.add(matrix[i][left]);
                }
                ++left;
            }
        }
        return list;
    }

}
