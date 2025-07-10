package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 *
 * @Author: liuye
 * @time: 2025/7/10$ 11:52$
 */
public class SearchInsert35 {

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int left = 0;
        int right = length - 1;
        // left <= right, 这里用小于等于，是为了保证所有场景都能覆盖
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 为什么返回left？
        // 当 target 存在于数组中时，在循环内就会直接返回
        // 当 target 不存在时，
        // 如果 target 比目标元素大，left 会等于数组长度，表示插入到末尾
        // 如果 target 比目标元素小，left 会等于插入位置的索引

        // 为什么不能返回right?
        // 因为循环结束时候，right = left - 1, 它指向的是前一个位置
        return left;
    }
}
