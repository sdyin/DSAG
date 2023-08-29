package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 345. 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * @Author: liuye
 * @time: 2023/8/29$ 12:40 下午$
 */
public class ReverseVowels_345 {

    /**
     *  双指针解法
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        String s1 = "aeiouAEIOU";
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (left < right && !s1.contains(chars[left] + "")) {
                left++;
            }
            while (left < right && !s1.contains(chars[right] + "")) {
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
