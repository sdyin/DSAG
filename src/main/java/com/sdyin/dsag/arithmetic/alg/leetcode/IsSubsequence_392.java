package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，
 * 你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * @Author: liuye
 * @time: 2023/9/1$ 6:32 上午$
 */
public class IsSubsequence_392 {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0){
            return true;
        }
        if(t == null || t.length() == 0){
            return false;
        }

        int sIndex = 0;
        int tIndex = 0;
        //双指针(针对两个字符串)
        while (sIndex < s.length() && tIndex < t.length()){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
            }
            tIndex++;
        }
        if(sIndex < s.length()){
            return false;
        }
        return true;
    }
}
