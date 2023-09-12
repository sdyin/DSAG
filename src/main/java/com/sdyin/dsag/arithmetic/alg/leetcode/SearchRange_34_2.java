package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * @Author: liuye
 * @time: 2023/8/6$ 11:38 上午$
 */
public class SearchRange_34_2 {

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;

        int leftIndex = findLeftBound(nums, 0, length, target);
        int rightIndex = findRightBound(nums, 0, length, target);

        int[] result;
        if (leftIndex > rightIndex - 1) {
            result = new int[]{-1, -1};
            return result;
        }
        // 为什么是right2 - 1 而不是right2，因为右节点是开节点
        result = new int[]{leftIndex, rightIndex - 1};
        return result;
    }

    // 查找匹配元素的最左边界
    // 左右均为下标索引(左闭右开)
    private int findRightBound(int[] nums, int left, int right, int target) {
        int middle = left + (right - left) / 2;
        while (left < right) {
            if (nums[middle] == target) {
                //匹配到元素时,左边界右移，依次匹配最右边界
                left = middle + 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle;
            }
        }
        return right;
    }

    // 查找匹配元素的最左边界
    // 左右均为下标索引(左闭右开)
    private int findLeftBound(int[] nums, int left, int right, int target) {
        int middle = left + (right - left) / 2;
        while (left < right) {
            if (nums[middle] == target) {
                //匹配到元素时,右边界向左移，依次匹配最左边界
                right = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle;
            }
        }
        return left;
    }


}
