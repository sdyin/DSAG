package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Stack;

/**
 * @Description: 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * @Author: liuye
 * @time: 2023/9/6$ 1:35 下午$
 */
public class DecodeString_394 {

    /**
     * 举个例子 s = "3[a2[c]]"
     * 先保存3以及'['之后的字符到栈中, 如果遇到']'则取出栈中的字符进行拼接
     * 构建辅助栈 stack， 遍历字符串 s 中每个字符 c；
     * 当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
     * 当 c 为字母时，在 res 尾部添加 c；
     * 当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置 00：
     *     记录此 [ 前的临时结果 res 至栈，用于发现对应 ] 后的拼接操作；
     *     记录此 [ 前的倍数 multi 至栈，用于发现对应 ] 后，获取 multi × [...] 字符串。
     *     进入到新 [ 后，res 和 multi 重新记录。
     * 当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res，其中:
     *    last_res是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a；
     *    cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2。
     *    返回字符串 res。
     *
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        // 存放数字
        Stack<Integer> countStack = new Stack<>();
        // 存放字符串
        Stack<StringBuilder> stringStack = new Stack<>();
        // 暂存当前字符串
        StringBuilder currentString = new StringBuilder();
        // 暂存当前数字
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                // 栈存放当前数字以及字符串
                countStack.push(k);
                // 保存已拼接的字符串
                stringStack.push(currentString);
                // 存放栈后重置当前数字以及字符串
                k = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                // 取出已拼接的字符串 再循环拼接当前字符以及数字，已拼接的字符串重新赋值给currentString
                StringBuilder decodedString = stringStack.pop();
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String result = decodeString(s);
        System.out.println(result);
    }
}
