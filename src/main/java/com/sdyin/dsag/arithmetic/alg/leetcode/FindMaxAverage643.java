package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description:
 *  leetcode 643. 子数组最大平均数 I
 *  给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * @Author: liuye
 * @time: 2021/2/4$ 下午7:36$
 */
public class FindMaxAverage643 {

    public static double findMaxAverage(int[] nums, int k) {

        int sum = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i < k){
                sum+= nums[i];
                temp+= nums[i];
                continue;
            } else{
                temp = temp - nums[i - k] + nums[i];
            }

            sum = Math.max(sum, temp);
        }
        return 1.0 * sum/k;
    }

    public static void main(String[] args) {
        int[] nums = {0,4,0,3,2};
        int k = 1;
        final double maxAverage = findMaxAverage(nums, k);
        System.out.println(maxAverage);
    }
}
