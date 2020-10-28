package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * @Description 1118.一个月有多少天
 * 「一月有多少天」：
 *
 * 给你一个数组T，这个数组存放的是近几天的天气气温，你返回一个等长的数组，
 * 计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0。
 *
 * @Author liuye
 * @Date 2020/10/28 10:00
 **/
public class DailyTemperatures1118 {

    /**
     * 思路
     * @param nums
     * @return
     */
    private static int[] dailyTemperatures(int[] nums){

        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0 ; i--) {
            //思路 如果当前下标索引处值大于 栈中第一个元素，则移除栈顶元素
            //如果当前下标索引处值小于 栈中第一个元素，则当前元素入栈
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            }

            //stack.peek() - i 得到索引的差别天数
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            //下标索引入栈
            stack.push(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {73,74,75,71,69,76};
        int[] arr = dailyTemperatures(nums);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
