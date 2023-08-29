package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 1071. 字符串的最大公因子
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 * @Author: liuye
 * @time: 2023/8/28$ 5:31 下午$
 */
public class GcdOfStrings_1071 {

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        // 求最大公约数
        int gcd = gcd(len1, len2);
        // 截取公约数长度的字符串
        String s = str1.substring(0, gcd);
        // 判断是否符合条件
        if (check(str1, s) && check(str2, s)) {
            return s;
        }
        return "";
    }

    /**
     * 判断是否符合条件
     * @param s
     * @param t
     * @return
     */
    private boolean check(String s, String t) {
        int len = s.length() / t.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(t);
        }
        if (sb.toString().equals(s)) {
            return true;
        }
        return false;
    }

    /**
     * 求最大公约数：
     * 计算两个数的最大公约数（Greatest Common Divisor）的。它使用了一个叫做欧几里得算法（Euclidean Algorithm）的方法。
     * 欧几里得算法的基本思想是：对于整数 a 和 b，当 a > b 时，a 和 b 的最大公约数等于 a 除以 b 的余数（a % b）和 b 的最大公约数。
     * 这个过程会一直重复，直到 a % b 的结果为 0，此时 b 就是 a 和 b 的最大公约数。
     *
     * 这段代码中的 gcd 方法就是用递归的方式实现了这个算法。
     * 当 len2（即 b）为 0 时，返回 len1（即 a）作为结果，
     * 否则就递归调用 gcd 方法，参数为 len2 和 len1 % len2。
     * @param len1
     * @param len2
     * @return
     */
    private int gcd(int len1, int len2) {
        return len2 == 0 ? len1 : gcd(len2, len1 % len2);
    }

}
