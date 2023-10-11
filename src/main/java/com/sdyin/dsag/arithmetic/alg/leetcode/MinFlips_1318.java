package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 1318. 或运算的最小翻转次数
 * 给你三个正整数 a、b 和 c。
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 *
 * @Author: liuye
 * @time: 2023/10/11$ 11:43 上午$
 */
public class MinFlips_1318 {

    public int minFlips(int a, int b, int c) {
        int result = 0;
        // 因为int 对应4 Byte, 所以是32位
        for (int i = 0; i < 32; i++) {
            // 右移i位，就是吧a 的第i 位移动到最后一位。
            // & 1： 因为1只有最后一位是1，所以就是获取a的最后一位
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            // 位数不匹配时候，需要添加翻转次数
            if ((bitA | bitB) != bitC) {
                if (bitC == 0) {
                    // bitC等于0，如果bitA, bitB 任一不为0, 都需要翻转
                    result += bitA + bitB;
                } else {
                    // bitC 等于1, 我们反转bitA 或者bitB 一次就可以
                    result += 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinFlips_1318 solution = new MinFlips_1318();
        int a = 2;
        int b = 6;
        int c = 5;
        int flips = solution.minFlips(a, b, c);
        System.out.println("Minimum flips required: " + flips);
    }
}
