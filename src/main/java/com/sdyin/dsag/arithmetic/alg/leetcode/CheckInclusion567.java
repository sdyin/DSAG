package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 567. 字符串的排列
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * @Author: liuye
 * @time: 2022/4/9$ 6:49 下午$
 */
public class CheckInclusion567 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        final boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }

    public static  boolean checkInclusion(String s1, String s2) {

        Map<String, Integer> needMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            String s = s1.charAt(i) + "";
            needMap.put(s, needMap.getOrDefault(s, 0) + 1);
        }
        Map<String, Integer> window = new HashMap<>();

        //左闭右开区间
        int left = 0;
        int right = 0;
        //匹配的字符数
        int valid = 0;

        //右侧节点向右移动
        while (right < s2.length()) {
            String s = s2.charAt(right) + "";
            right++;

            if (needMap.containsKey(s)) {
                window.put(s, window.getOrDefault(s, 0) + 1);
                if(needMap.get(s).equals(window.get(s))) {
                    valid++;
                }
            }

            //因为是包含排列，即子串长度肯定相同
            while (right - left == s1.length()) {
                //当满足字符数相同,即代表匹配
                if(valid == needMap.size()) {
                    return true;
                }
                //否则左节点右移
                String str = s2.charAt(left) + "";
                left++;

                if(needMap.containsKey(str)) {
                    if (needMap.getOrDefault(str, 0).equals(window.getOrDefault(str, 0))) {
                        valid--;
                    }
                    //先上面的匹配,再下面的扣减,不然匹配不上
                    window.put(str, window.getOrDefault(str, 0) -1);
                }
            }
        }
        return false;
    }
}
