package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.LinkedList;
import java.util.concurrent.DelayQueue;
import java.util.stream.Collectors;

/**
 * @Description: 2390. 从字符串中移除星号
 * 给你一个包含若干星号 * 的字符串 s 。
 *
 * 在一步操作中，你可以：
 *
 * 选中 s 中的一个星号。
 * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
 * 返回移除 所有 星号之后的字符串。
 *
 * 注意：
 *
 * 生成的输入保证总是可以执行题面中描述的操作。
 * 可以证明结果字符串是唯一的。
 *
 * 示例 1：
 *
 * 输入：s = "leet**cod*e"
 * 输出："lecoe"
 * 解释：从左到右执行移除操作：
 * - 距离第 1 个星号最近的字符是 "leet**cod*e" 中的 't' ，s 变为 "lee*cod*e" 。
 * - 距离第 2 个星号最近的字符是 "lee*cod*e" 中的 'e' ，s 变为 "lecod*e" 。
 * - 距离第 3 个星号最近的字符是 "lecod*e" 中的 'd' ，s 变为 "lecoe" 。
 * 不存在其他星号，返回 "lecoe" 。
 * 示例 2：
 *
 * 输入：s = "erase*****"
 * 输出：""
 * 解释：整个字符串都会被移除，所以返回空字符串。
 *
 * @Author: liuye
 * @time: 2023/9/5$ 11:34 下午$
 */
public class RemoveStars_2390 {

    /**
     *  使用栈的方式
     * @param s
     * @return
     */
    public static String removeStars(String s) {
        int length = s.length();
        LinkedList<Character> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c == '*'){
                deque.removeLast();
            }else {
                deque.addLast(c);
            }
        }
        // 将队列转换为字符串
        return deque.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";
        String s1 = removeStars(s);
        System.out.println(s1);
    }
}
