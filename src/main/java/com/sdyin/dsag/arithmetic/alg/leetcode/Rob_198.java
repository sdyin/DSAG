package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode.198 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @Author: liuye
 * @time: 2023/12/6$ 2:10 下午$
 */
public class Rob_198 {

    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] amountArr = new int[length];
        // 初始值
        amountArr[0] = nums[0];
        amountArr[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            // 状态转移方程
            amountArr[i] = Math.max(amountArr[i - 1], amountArr[i - 2] + nums[i]);
        }
        // 可以选择最后一个或者倒数第二个
        return Math.max(amountArr[length - 1], amountArr[length - 2]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        int rob = rob(nums);
        System.out.println(rob);
    }
}
