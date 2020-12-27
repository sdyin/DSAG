package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: 84 柱状图中最大的矩形
 * //给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * //
 * // 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * //
 * //
 * //
 * //
 * //
 * // 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * //
 * //
 * //
 * //
 * //
 * // 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * //
 * //
 * //
 * // 示例:
 * //
 * // 输入: [2,1,5,6,2,3]
 * //输出: 10
 * // Related Topics 栈 数组
 * // 👍 1099 👎 0
 * @Author: liuye
 * @time: 2020/12/26$ 下午9:26$
 */
public class LargestRectangleArea84 {

    /**
     * 暴力解法
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int data = heights[i];
            int right = i;
            int left = i;
            while (right < heights.length - 1 && heights[right + 1] >= data) {
                ++right;
            }

            while (left > 0 && heights[left - 1] >= data) {
                --left;
            }

            res = Math.max(res, (right - left + 1) * data);
        }
        return res;
    }

    /**
     * TODO 单调栈递增
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {

        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            // 队列不为空且 后一元素高度小于当前元素（确定了前一元素宽度下标截止点）
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                //队列中移除当前元素，并获取高度值
                int curHeight = heights[stack.pollLast()];
                //队列不为空，循环与之前元素比较（从右向左）
                //此处 heights[stack.peekLast()] == curHeight 而不是判断 heights[stack.peekLast()] >= curHeight
                //是因为不会出现大于场景，如果大于之前循环就已经处理
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                //获取宽度
                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            //入队
            stack.addLast(i);
        }

        //处理队列中未确定宽度的节点
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            //此处 heights[stack.peekLast()] == curHeight 而不是判断 heights[stack.peekLast()] >= curHeight
            //是因为不会出现大于场景，如果大于之前循环就已经处理
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;

    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>(5);
        Integer result = stack.peekLast();
        System.out.println(result);
        System.out.println(stack.isEmpty());
    }
}
