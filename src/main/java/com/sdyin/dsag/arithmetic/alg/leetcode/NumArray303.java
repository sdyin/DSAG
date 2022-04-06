package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 303.区域和检索 - 数组不可变
 * 给你一个整数数组，计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * @Author: liuye
 * @time: 2022/4/6$ 7:32 下午$
 */
public class NumArray303 {

    private int[] preSum;

    public NumArray303(int[] nums) {
        //因为区间left 和 right都包含，所以我们用preSum[i] 表示前 i-1(索引位位)的和，preSum长度也就多1
        preSum = new int[nums.length + 1];
        //计算preSum 的累加和, 从1开始，preSum[0]就是初始值0
        for (int i = 1; i < nums.length + 1; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }

    /**
     * 这样计算时间复杂度就为O(1)了。
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        //left 和 right 也是索引位，即从0开始
        return preSum[right+1] - preSum[left];
    }
}
