package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;

/**
 * @Description leetcode 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 字母异位词: 排序后字母相同
 * @Author liuye
 * @Date 2020/11/22 18:37
 **/
public class IsAnagram242 {

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        char[] s1 = s.toCharArray();
        char[] t1 =t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        isAnagram(s,t);
    }
}

