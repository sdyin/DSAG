package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 1768. 交替合并字符串
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 * @Author: liuye
 * @time: 2023/8/28$ 5:23 下午$
 */
public class MergeAlternately_1768 {

    public  static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int l1 = word1.length();
        int l2 = word2.length();
        int length = Math.min(l1, l2);

        for (int i = 0; i < length; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if (l1 > l2) {
            sb.append(word1.substring(l2));
        } else if (l1 < l2) {
            sb.append(word2.substring(l1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String word1 = "abcdefghijk";
        String word2 = "pqrs";
        String s = mergeAlternately(word1, word2);
        System.out.println(s);
    }
}
