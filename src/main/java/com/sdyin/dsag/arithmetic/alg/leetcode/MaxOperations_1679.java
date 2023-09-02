package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 1679. K 和数对的最大数目
 * 给你一个整数数组 nums 和一个整数 k 。
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 * 返回你可以对数组执行的最大操作数。
 *
 * @Author: liuye
 * @time: 2023/9/1$ 3:08 下午$
 */
public class MaxOperations_1679 {

    /**
     * 执行超时
     * @param nums
     * @param k
     * @return
     */
    public static int maxOperations(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            // 已经被置为0,则跳过
            if (nums[i] == 0){
                continue;
            }
            int num = nums[i];
            int target = k - num;
            // 目标值小于等于0,则跳过(确保是两个数之和)
            if (target <= 0) {
                continue;
            }
            // 匹配目标值下标索引
            // 因为数组可能更新，所以每次都重新生成集合
            int index = Arrays.stream(nums).boxed().collect(Collectors.toList()).indexOf(target);
            if(index != -1 && index != i){
                // 题目指定 nums[i] >=1, 所以可以先置为0,再过滤
                nums[i] = 0;
                nums[index] = 0;
                result++;
            }
        }
        // 过滤数组中为0的元素
        nums = Arrays.stream(nums).filter(num -> num != 0).toArray();
        return result;
    }


    public static int maxOperations2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            //存在则增加计数
            if (map.getOrDefault(k - num, 0) > 0) {
                count++;
                map.put(k - num, map.get(k - num) - 1);
            } else {
                // 不存在则添加当前元素到map
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,3,1,1,4,1};
        int k = 4;
        int i = maxOperations(nums, k);
        System.out.println(i);
    }
}
