package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
 * 返回一个长度为 n + 1 的数组 ans 作为答案。
 * @Author: liuye
 * @time: 2023/10/10$ 10:24 上午$
 */
public class CountBits_338 {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 如果i是偶数，那么它的二进制中1的个数与i/2的二进制中1的个数相同,
            // 因为i为偶数时，相当于i/2 向左移动了一位
            if ((i & 1) == 0) {
                result[i] = result[i >> 1];
            } else {
                // 如果i是奇数，那么它的二进制中1的个数等于i-1的二进制中1的个数加1
                // 因为i为奇数时，实际上就是i-1 的尾数0变成1
                result[i] = result[i - 1] + 1;
            }

            // 优化写法：如果是奇数，也是向左移一位加上1
            // 使用 i & (i - 1) 来清除 i 最低位的 1，并获取 i 中 1 的个数
            // result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int i = 3;
        int result = i & 1;
        System.out.println(result);
    }
}
