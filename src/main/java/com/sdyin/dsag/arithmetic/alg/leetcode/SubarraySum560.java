package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: leetcode 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 注意了：求子数组的个数，子数组那说明肯定是数组中连续的元素了。
 * @Author: liuye
 * @time: 2022/4/6$ 11:02 下午$
 */
public class SubarraySum560 {

    /**
     * 利用前缀和暴力解法
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //先求出前缀和
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和 + 哈希表优化
     * 这里核心要明白：因为是前缀和，所以数组preSum[i] 是0到3累加的和，所以preSum[i] - preSum[i] 就是j到i的累加和。
     * 那如果我们保存一个map(类似两数之和) map保存的key是 preSum[i] - k(连续子数组目标和),
     * 则后续只需要判断map中是否存在该key，就知道该索引处是否符合
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和为0出现1次
        map.put(0, 1);
        int sum = 0, count = 0;

        for (int num : nums) {
            // 当前元素值为 num
            // 当前前缀和
            sum += num;
            // 查找是否存在前缀和为 (targetSum = sum - k)
            // 为什么是target = sum - k。
            // 因为当前位置前缀和为sum, 如果要找的连续子数组和为k, 则需要找到前缀和为sum - k的位置。
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // 更新哈希表
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,1,5,7,8,9,1,1,4};
        int k = 6;
        int result = subarraySum2(nums, k);
        System.out.println(result);
    }
}
