package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description:  1493. 删掉一个元素以后全为 1 的最长子数组
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 如果不存在这样的子数组，请返回 0 。
 *
 * 提示 1 <= nums.length <= 10^5
 * nums[i] 要么是 0 要么是 1 。
 *
 * @Author: liuye
 * @time: 2023/9/3$ 2:54 下午$
 */
public class LongestSubarray_1493 {

    /**
     * 思路： 使用滑动窗口，保证窗口中最多只有1个元素为0，最大的连续元素1就是这个窗口的大小。
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int max = 0;
        int zeroCount = 0;

        while (left < len && right < len) {

            if(nums[right] == 0){
                zeroCount++;
            }
            // 当元素为0的数量超过1时，移动左指针，直到窗口中元素为0的数量不超过1
            while (zeroCount > 1) {
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        // 因为题目要求是删除一个非0元素的最大值，所以最大值要减1
        return max - 1;
    }
}
