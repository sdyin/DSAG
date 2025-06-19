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


    public String minWindow2(String s, String t) {

        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        // 定义一个hashmap 存储t的字符和个数
        HashMap<Character, Integer> need = new HashMap<>();

        // 初始化need
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 左闭右开区间
        int left = 0, right = 0;
        // 需要匹配的字符总数
        int count = t.length();
        // 最少字符长度
        int minLen = Integer.MAX_VALUE;
        // 最小左边界， 因为最后要返回符合的子串，所以需要记录左边界
        int minLeft = 0;

        // 扩大窗口
        while (right < s.length()) {
            char c = s.charAt(right);
            // 如果当前字符在目标中，减少计数
            if (need.containsKey(c)) {
                if (need.get(c) > 0) {
                    count--;
                }
                need.put(c, need.get(c) - 1);
            }

            // 窗口左闭右开，所以这里是right++
            // 如果是while (right < s.length()) 循环末尾，缩小窗口逻辑时，right 还没有加1。对应的是左闭右闭。
            right++;

            // 当所有字符都匹配时，缩小窗口
            while (count == 0) {
                // 判断是否需要更新最优解：更新最小长度和最小左边界
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                char d = s.charAt(left);
                // 如果移出的字符在目标中，增加计数
                if (need.containsKey(d)) {
                    need.put(d, need.get(d) + 1);
                    if (need.get(d) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
