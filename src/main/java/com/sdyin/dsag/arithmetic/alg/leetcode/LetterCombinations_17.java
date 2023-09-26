package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @Description:
 * @Author: liuye
 * @time: 2023/9/26$ 5:11 下午$
 */
public class LetterCombinations_17 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        backtrack(result, phoneMap, digits, 0, new StringBuilder());
        return result;
    }

    /**
     *
     * @param result 结果集
     * @param phoneMap 手机数字->字母映射map
     * @param digits 入参数字字符串
     * @param index 字符串下标索引
     * @param current
     */
    private void backtrack(List<String> result, Map<Character, String> phoneMap, String digits, int index, StringBuilder current) {
        // 当索引大小等于字符串长度时, 代表已经都遍历完成了
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // 获取下标索引对应字符
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        // 遍历字母
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            // 遍历下一数字索引
            backtrack(result, phoneMap, digits, index + 1, current);
            // 在递归返回后，回溯到上一个状态
            current.deleteCharAt(current.length() - 1);
        }
    }

}
