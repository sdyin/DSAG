package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;

/**
 * @Description: 1657. 确定两个字符串是否接近
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 *
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 *
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 * @Author: liuye
 * @time: 2023/9/5$ 1:52 下午$
 */
public class CloseStrings_1657 {

    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        //初始化数组,存放两个字符出现的次数
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        //统计每个字符出现的次数
        for(int i = 0; i < word1.length(); i++){
            arr1[word1.charAt(i) - 'a']++;
            arr2[word2.charAt(i) - 'a']++;
        }
        //存在不同的字符, 返回false(字符转换时，只能转换现有的字符)
        for(int i = 0; i < 26; i++){
            if((arr1[i] == 0 && arr2[i] != 0) || (arr1[i] != 0 && arr2[i] == 0)){
                return false;
            }
        }
        //数组排序
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        //核心逻辑：排序后，数组索引处元素个数相等则说明可以转换
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
