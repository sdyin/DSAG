package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author: liuye
 * @time: 2022/3/20$ 3:43 下午$
 */
public class LengthOfLongestSubstring3 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int max = 0;
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            String c = s.charAt(i) + "";
            if (s2.contains(c)) {
                int index = s2.indexOf(c);
                //要过滤掉当前元素，所以下标 + 1
                s2 = s2.substring(index + 1);
            }
            s2 = s2 + c;
            max = Math.max(max, s2.length());
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        final int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
