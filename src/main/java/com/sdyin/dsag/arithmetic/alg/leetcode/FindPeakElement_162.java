package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * @Author: liuye
 * @time: 2023/9/25$ 2:11 下午$
 */
public class FindPeakElement_162 {

    /**
     * 题目假设 nums[-1] = nums[n] = -∞ ，也就是说是存在中间元素的峰值的
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}
