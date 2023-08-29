package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 151. 反转字符串中的单词
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * @Author: liuye
 * @time: 2023/8/29$ 2:56 下午$
 */
public class ReverseWords_115 {

    public static void main(String[] args) {
        String s = "the sky  is  blue ";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }

    public static String reverseWords(String s) {
        List<String> list = Arrays.stream(s.split(" ")).filter(it -> !"".equals(it)).collect(Collectors.toList());
        List<String> list2 = new ArrayList<>();
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            list2.add(list.get(i));
        }
        String result = list2.stream().collect(Collectors.joining(" "));
        return result;
    }
}
