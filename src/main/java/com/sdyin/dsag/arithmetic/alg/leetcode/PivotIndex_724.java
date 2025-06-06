package com.sdyin.dsag.arithmetic.alg.leetcode;


/**
 * @Description: 724. 寻找数组的中心下标
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 * @Author: liuye
 * @time: 2023/9/4$ 9:42 下午$
 */
public class PivotIndex_724 {

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 因为不添加当前元素，所以再当前索引位置先判断
            // 首先排除结果是小数的位置，因为nums 是整数数组
            if ((sum - nums[i]) % 2 == 0 && (leftSum == (sum - nums[i])/2)) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,-1,-1,-1};
        int i = pivotIndex(nums);
        System.out.println(i);
    }
}
