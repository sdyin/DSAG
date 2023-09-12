package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 85 最大矩阵
 * //给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
 * //,["1","0","0","1","0"]]
 * //输出：6
 * //解释：最大矩形如上图所示。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：matrix = []
 * //输出：0
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：matrix = [["0"]]
 * //输出：0
 * //
 * //
 * // 示例 4：
 * //
 * //
 * //输入：matrix = [["1"]]
 * //输出：1
 * //
 * //
 * // 示例 5：
 * //
 * //
 * //输入：matrix = [["0","0"]]
 * //输出：0
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // rows == matrix.length
 * // cols == matrix[0].length
 * // 0 <= row, cols <= 200
 * // matrix[i][j] 为 '0' 或 '1'
 * //
 * // Related Topics 栈 数组 哈希表 动态规划
 * // 👍 742 👎 0
 * @Author: liuye
 * @time: 2020/12/26$ 下午7:31$
 */
public class MaximalRectangle85 {


    public int maximalRectangle(char[][] matrix) {

        return 0;
    }


    public static int[] nextGreaterElement (int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            //这个while很关键，因为有可能不止一个数可以被计算出来
            while (!deque.isEmpty() && value > nums[deque.peek()]) {
                //根据题意执行计算
                //.....
                res[deque.peek()] = i - deque.peek();
                deque.pop();
            }
            deque.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {6,3,2,7,8,5};
        int[] result = nextGreaterElement(nums);
        Arrays.stream(result).forEach(System.out::println);
    }
}
