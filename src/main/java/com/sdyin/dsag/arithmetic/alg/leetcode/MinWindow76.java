package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * @Author: liuye
 * @time: 2022/4/9$ 3:31 下午$
 */
public class MinWindow76 {

    public String minWindow(String s, String t) {
        Map<String, Integer> needMap = new HashMap<>();
        Map<String, Integer> window = new HashMap<>();
        //需要的元素个数
        for (int i = 0; i < t.length(); i++) {
            String str = t.charAt(i) + "";
            needMap.put(str, needMap.getOrDefault(str, 0) + 1);
        }

        //左闭右开区间
        int left = 0;
        int right = 0;
        // 区间满足的字符个数，valid == needMap.size() 即符合
        int valid = 0;

        //最小区间的起始位置和最小长度
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        //窗口右侧右移，增大窗口
        //为什么不能小于等于？ 因为right从0开始,等于的时候，charAt 会角标越界
        while (right < s.length()) {
            //即将进入区间的元素
            final String c = s.charAt(right) + "";
            right++;

            if (needMap.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                //字符达到符合数量时,满足条件的字符计数增加1
                if (needMap.getOrDefault(c,0).equals(window.getOrDefault(c, 0))) {
                    valid++;
                }
            }

            //窗口左侧右移,缩小窗口
            while (valid == needMap.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                //即将移除区间的元素
                String str = s.charAt(left) + "";
                left++;

                if (needMap.containsKey(str)) {
                    //需要的字符
                    if (needMap.getOrDefault(str, 0).equals(window.getOrDefault(str, 0))) {
                        valid--;
                    }
                    window.put(str, window.getOrDefault(str, 0) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
