package com.sdyin.dsag.arithmetic.alg.leetcode;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 862. 和至少为 K 的最短子数组
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。
 * 如果不存在这样的 子数组 ，返回 -1 。
 *
 * 子数组 是数组中 连续 的一部分。
 *
 * 示例 1：
 *
 * 输入：nums = [1], k = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -105 <= nums[i] <= 105
 * 1 <= k <= 109
 * @Description:
 * @Author: liuye
 * @time: 2025/9/21$ 19:06$
 */
public class ShortestSubarray_862 {

    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;
        // 前缀和可能很大，用 long
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int res = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int j = 0; j <= n; j++) {
            // 检查是否满足条件，尝试更新最短长度
            while (!deque.isEmpty() && prefix[j] - prefix[deque.peekFirst()] >= k) {
                res = Math.min(res, j - deque.pollFirst());
            }
            // 保持单调递增（保证 prefix[j] 更小，更可能成为最优起点）
            while (!deque.isEmpty() && prefix[j] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(j);
        }
        return res <= n ? res : -1;
    }
}
