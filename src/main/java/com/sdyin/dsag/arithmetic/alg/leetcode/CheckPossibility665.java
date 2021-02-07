package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;

/**
 * @Description: 665. 非递减数列
 * 给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的：对于数组中所有的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2021/2/7$ 上午10:28$
 */
public class CheckPossibility665 {

    /**
     * 原始思路
     *
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        int left = 0;
        int right = 0;
        int length = nums.length;
        int[] arr = {};
        arr = Arrays.copyOf(nums, length);
        for (int i = 1; i < length; i++) {
            if (arr[i] < arr[i - 1]) {
                left++;
                arr[i] = arr[i - 1];
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] > nums[i]) {
                right++;
                nums[i - 1] = nums[i];
            }
        }
        return (left >= 2 && right >= 2) ? false : true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1};
        final boolean b = checkPossibility(nums);
        System.out.println(b);
    }
}
