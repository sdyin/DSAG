package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 334. 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * 注意题目意思：不是说连续下标的三元组，只需要存在任意位置
 * @Author: liuye
 * @time: 2023/8/30$ 11:29 上午$
 */
public class IncreasingTriplet_334 {

    // 时间复杂度 0(n^2)，leetcode 显示超出时间限制...
    public static boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int tmp = nums[i];
            int num = 1;
            for (int j = i+1; j < length; j++) {
                if (nums[j] > tmp) {
                    num++;
                    tmp = nums[j];
                }
                if (num == 3) {
                    return true;
                }
                // 如果第2个元素匹配到更小的元素，则将tmp重新赋值
                if (nums[j] > nums[i] && nums[j] < tmp) {
                    tmp = nums[j];
                }
            }
        }
        return false;
    }

    /**
     * 贪心算法. 时间复杂度0(n)
     *
     * @param nums
     * @return
     */
    public static boolean increasingTriplet2(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        // 定义最小值和中间值
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,0,4,1,3};
        boolean b = increasingTriplet(nums);
        System.out.println(b);
    }
}
