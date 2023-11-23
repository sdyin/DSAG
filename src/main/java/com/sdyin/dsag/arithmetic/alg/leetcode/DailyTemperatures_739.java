package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description: 739. 每日温度
 * <p>
 *     给定一个整数数组 temperatures ，表示每天的温度。
 *     请根据每日 气温 列表 temperatures ，重新生成一个列表，
 *     对应位置的输出是需要再等待多久温度才会升高超过该日的天数。
 *     如果之后都不会升高，请在该位置用 0 来代替。
 *     示例 1:
 *     输入: temperatures = [73,74,75,71,69,72,76,73]
 *     输出: [1,1,4,2,1,1,0,0]
 *     示例 2:
 *     输入: temperatures = [30,40,50,60]
 *     输出: [1,1,1,0]
 * @Author: liuye
 * @time: 2023/11/23$ 11:48 上午$
 */
public class DailyTemperatures_739 {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Arrays.fill(result, 0);
        // 单调栈，存储数组对应的下标索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            // 如果栈不为空，且当前元素值大于栈顶元素，则出栈
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 栈顶元素对应的结果值为当前元素下标减去栈顶元素下标
                result[stack.peek()] = i - stack.peek();
                // 栈顶元素出栈
                stack.pop();
            }
            // 入栈,存储递增元素的下标
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = dailyTemperatures(temperatures);
        Arrays.stream(result).forEach(System.out::println);
    }
}
