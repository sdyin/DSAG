package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 438. 找到字符串中所有字母异位词
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 示例 2:
 *
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *
 * @Author: liuye
 * @time: 2022/4/9$ 7:34 下午$
 */
public class FindAnagrams438 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        final List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }

    public static List<Integer> findAnagrams(String s, String p) {

        Map<String, Integer> needMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            String str = p.charAt(i) + "";
            needMap.put(str, needMap.getOrDefault(str, 0) + 1);
        }
        Map<String, Integer> window = new HashMap<>();

        //左开右闭
        int left = 0;
        int right = 0;
        //满足的字符个数
        int valid = 0;
        //结果集
        List<Integer> list = new ArrayList<>();

        while (right < s.length()) {
            //即将加入区间的字符
            final String str = s.charAt(right) + "";
            right++;
            if(needMap.containsKey(str)) {
                window.put(str, window.getOrDefault(str, 0) + 1);
                if (needMap.getOrDefault(str, 0).equals(window.getOrDefault(str, 0))) {
                    valid++;
                }
            }

            //左侧节点右移条件
            while (right - left == p.length()) {
                //满足时添加起点索引
                if (valid == needMap.size()) {
                    list.add(left);
                }
                String s2 = s.charAt(left) + "";
                if(needMap.containsKey(s2)) {
                    if (needMap.getOrDefault(s2, 0).equals(window.getOrDefault(s2, 0))) {
                        valid--;
                    }
                    window.put(s2, window.getOrDefault(s2, 0) - 1);
                }
                left++;
            }
        }
        return list;
    }
}
