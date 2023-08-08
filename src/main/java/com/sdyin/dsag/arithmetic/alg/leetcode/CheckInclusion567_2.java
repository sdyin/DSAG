package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * @Author: liuye
 * @time: 2023/8/8$ 3:15 下午$
 */
public class CheckInclusion567_2 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        final boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }

    public static  boolean checkInclusion(String s1, String s2) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> needMap = new HashMap<>();
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            String s = s1.charAt(i) + "";
            needMap.put(s, needMap.getOrDefault(s, 0) + 1);
        }
        int needValidSize = needMap.keySet().size();
        int validSize = 0;

        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            //添加right节点
            String s = s2.charAt(right) + "";
            if (needMap.containsKey(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
                if (map.get(s).equals(needMap.get(s))) {
                    validSize++;
                }
            }

            // 如果字符数超过s1长度,左侧节点需要向右移动
            if (right >= length) {
                //左侧节点向右移动
                String str = s2.charAt(left) + "";
                if (needMap.containsKey(str)) {
                    if (map.get(str).equals(needMap.get(str))) {
                        validSize--;
                    }
                    // 先判断再更新
                    map.put(str, map.getOrDefault(str, 0) - 1);
                }
                left++;
            }

            //当满足字符数相同,即代表匹配
            if (validSize == needValidSize) {
                return true;
            }
            //右侧节点向右移动
            right++;
        }
        return false;
    }
}
