package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description:  //TODO dp方式待补充
 * 486. 预测赢家
 * 给定一个表示分数的非负整数数组。
 * 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，
 * 然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。
 * 直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 *
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * @Author: liuye
 * @time: 2020/9/1$ 下午8:02$
 */
public class PreWin {

    /**
     * 递归方式
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        return helper(0, nums.length - 1, nums) >= 0;
    }

    private int helper(int i, int j, int[] nums) {
        if (i == j) {    // 递归的出口，此时只有一个选择，并且没有剩余的可选
            return nums[i];
        }
        int pickI = nums[i] - helper(i + 1, j, nums); // 选择左端
        int pickJ = nums[j] - helper(i, j - 1, nums); // 选择右端
        return Math.max(pickI, pickJ);
    }

}
