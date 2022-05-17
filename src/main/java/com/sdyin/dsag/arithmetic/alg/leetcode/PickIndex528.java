package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Random;

/**
 * @Description: 528. 按权重随机选择
 * 给你一个 下标从 0 开始 的正整数数组w ，其中w[i] 代表第 i 个下标的权重。
 *
 * 请你实现一个函数pickIndex，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i的 概率 为 w[i] / sum(w) 。
 *
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3)= 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3)= 0.75（即，75%）。
 *
 * 示例 1：
 *
 * 输入：
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * 输出：
 * [null,0]
 * 解释：
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
 *
 * @Author: liuye
 * @time: 2022/5/16$ 9:49 下午$
 */
public class PickIndex528 {

    // 前缀和数组
    private int[] preSum;
    private Random rand = new Random();

    public PickIndex528(int[] w) {
        final int n = w.length;
        //构建前缀和数组， 偏移一位留给 preSum[0]
        preSum = new int[n + 1];
        preSum[0] = 0;

        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + w[i-1];
        }

    }

    /**
     * 1、根据权重数组 w 生成前缀和数组 preSum。
     * 2、生成一个取值在 preSum 之内的随机数，用二分搜索算法寻找大于等于这个随机数的最小元素索引。
     * 3、最后对这个索引减一（因为前缀和数组有一位索引偏移），就可以作为权重数组的索引，即最终答案:
     * @return
     */
    public int pickIndex() {
        int n = preSum.length;
        // 在闭区间 [1, preSum[n - 1]] 中随机选择一个数字
        int target = rand.nextInt(preSum[n - 1]) + 1;
        // 获取 target 在前缀和数组 preSum 中的索引
        // 前缀和数组 preSum 和原始数组 w 有一位索引偏移
        return left_bound(preSum, target) - 1;
    }

    //搜索左侧边界的二分搜索
    public int left_bound(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        //左闭右开区间
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

}
