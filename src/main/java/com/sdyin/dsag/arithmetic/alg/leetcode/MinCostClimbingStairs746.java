package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 746. 使用最小花费爬楼梯
 * 数组的每个索引作为一个阶梯，第i个阶梯对应着一个非负数的体力花费值cost[i](索引从0开始)。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * <p>
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例1:
 * <p>
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 * 示例 2:
 * <p>
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 * <p>
 * cost的长度将会在[2, 1000]。
 * 每一个cost[i] 将会是一个Integer类型，范围为[0, 999]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2020/12/21$ 下午2:09$
 */
public class MinCostClimbingStairs746 {

    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if(length == 0){
            return 0;
        }
        int[] dp = new int[length + 1];
        //到达0阶和1阶 初始值为耗费0
        dp[0] = dp[1] = 0;
        for (int i = 2; i < length; i++){
            //状态转移方程式
            dp[i] = Math.min(dp[i - 1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[length];
    }

    public static void main(String[] args) {
        int[] cost = {0,0,0,0};
        int i = minCostClimbingStairs(cost);
        System.out.println(i);
    }
}
