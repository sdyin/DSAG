package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Description: 151. 反转字符串中的单词
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2023/7/6$ 3:18 下午$
 */
public class ReverseWords_151 {

    public static String reverseWords(String s) {
        if (s.length() <= 1 || s.trim().length() <= 1) {
            return s;
        }
        String[] split = s.split(" ");
        // 单词数量
        int length = split.length;
        // 中点位置
        int midIndex = length / 2;
        // 反转单词位置
        for (int i = 0; i < midIndex; i++) {
            String tmp = split[i];
            split[i] = split[length - i - 1];
            split[length - i - 1] = tmp;
        }
        //因为split方法会将多个连续空格分割成空字符串,所以需要过滤掉空字符串
        String s1 = Arrays.stream(split).filter(it -> it.trim().length() >= 1).collect(Collectors.joining(" "));
        return s1;
    }

    public static void main(String[] args) {
        String s = "a good  example";
        String s1 = reverseWords(s);
        System.out.println(s1 + "----");
    }
}
