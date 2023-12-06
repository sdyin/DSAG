package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode.1137 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * @Author: liuye
 * @time: 2023/12/6$ 9:54 上午$
 */
public class Tribonacci_1137 {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        // n从0开始，所以需要初始化 n+1
        int[] numArr = new int[n+1];
        numArr[0] = 0;
        numArr[1] = 1;
        numArr[2] = 1;
        numArr[3] = 2;
        for (int i = 4; i <= n; i++) {
            numArr[i] = numArr[i - 1] + numArr[i - 2] + numArr[i - 3];
        }
        return numArr[n];
    }
}
