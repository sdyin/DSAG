package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * @Author: liuye
 * @time: 2023/8/29$ 4:00 下午$
 */
public class ProductExceptSelf_238 {

    /**
     * 解法： 两次for循环，第一次求元素左边乘积，第二次求元素右边乘积
     * 最后将左右乘积相乘即为结果。
     * 循环时，每一次都是用上一次结果，避免循环内部再次循环
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        // 先求元素左边乘积
        for (int i = 1; i < length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        // 再求元素右边乘积
        // 最右侧，临时变量辅助定义为1(因为最右侧元素右边没有元素了，无需再处理，乘1等于自身即可)
        int tmp = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = result[i] * tmp;
            tmp = tmp * nums[i];
        }
        return result;
    }
}
