package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1456. 定长子串中元音的最大数目
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 * @Author: liuye
 * @time: 2023/9/3$ 2:11 下午$
 */
public class MaxVowels_1456 {


    public int maxVowels(String s, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("e", 1);
        map.put("i", 1);
        map.put("o", 1);
        map.put("u", 1);

        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            //存在则增加计数
            if (map.containsKey(String.valueOf(s.charAt(i)))) {
                count++;
            }
            //窗口大小为k时，移除最左边的元素
            if (i >= k) {
                if (map.containsKey(String.valueOf(s.charAt(i - k)))) {
                    count--;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
