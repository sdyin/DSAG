package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode.746. 使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 示例 1：
 * <p>
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 * <p>
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 * @Author: liuye
 * @time: 2023/12/6$ 10:46 上午$
 */
public class MinCostClimbingStairs_746 {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] numArr = new int[cost.length];
        numArr[0] = cost[0];
        numArr[1] = cost[1];
        // 到达指定台阶时的最小花费
        for (int i = 2; i < cost.length; i++) {
            // 状态转移方程: f(n) = min(f(n-1), f(n-2)) + cost[n]
            numArr[i] = Math.min(numArr[i - 1], numArr[i - 2]) + cost[i];
        }
        // 最后一步可以选择最后一个台阶或者倒数第二个台阶
        return Math.min(numArr[cost.length - 1], numArr[cost.length - 2]);
    }
}
