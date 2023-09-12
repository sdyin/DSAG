package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description:
 * @Author: liuye
 * @time: 2022/5/15$ 5:39 下午$
 */
public class Search {

    public int search(int[] nums, int target) {
        int left = 0;
        //初始化下标索引是 length-1， 即是下标索引
        int right = nums.length - 1;

        //因为我们左右区间均是闭区间[left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                //左右区间都是闭区间,所以直接mid + 1
                left = mid + 1;
            } else if (nums[mid] > target) {
                //左右区间都是闭区间,所以直接mid -1
                right = mid - 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {

        int first = leftBound(nums, target);
        int last = rightBound(nums, target);
        if (first > last) {
            return new int[]{-1, -1};
        }
        return new int[]{first, last};
    }

    private int leftBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

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

    private int rightBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return right - 1;
    }
}
