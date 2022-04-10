package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 滑动时间窗口方式解题
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        //左闭右开区间
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Map<String, Integer> window = new HashMap<>();

        //右侧节点右移
        while (right < s.length()) {
            String str = s.charAt(right) + "";
            right++;
            //左侧节点右移条件：当有重复元素时
            while (window.containsKey(str)) {
                String s2 = s.charAt(left) + "";
                left++;
                window.remove(s2);
            }
            window.put(str, 1);
            maxLen = Math.max(maxLen, window.size());
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        final int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
