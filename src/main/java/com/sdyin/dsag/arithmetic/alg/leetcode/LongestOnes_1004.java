package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 1004. 最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 *
 * @Author: liuye
 * @time: 2023/9/3$ 2:31 下午$
 */
public class LongestOnes_1004 {

    /**
     * 思路：维护一个滑动窗口，使得窗口内的0的数量不超过k。
     * 当窗口内0的数量超过k时，我们就需要移动窗口的左边界，直到窗口内0的数量不超过k。
     * 窗口的大小也就是连续1的最大个数。
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int max = 0;
        int zeroCount = 0;

        //
        while (left < len && right < len) {

            if(nums[right] == 0){
                zeroCount++;
            }
            // 当窗口内0的数量超过k时，我们就需要移动窗口的左边界，直到窗口内0的数量不超过k。
            while (zeroCount > k) {
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }

            // 当前窗口最大连续1的个数
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
