package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和
 * @Author: liuye
 * @time: 2022/1/23$ 12:39 下午$
 */
public class TwoSum1 {

    /**
     * 暴力解法： 迭代方法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int a = -1,b = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == target - num){
                    a = i;
                    b = j;
                }
            }
        }
        int[] result = {a, b};
        return result;
    }

    /**
     * map 解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int needKey = target - nums[i];
            if(map.containsKey(needKey)) {
                // 由于map未初始化值， 所以构造数组时顺序相反，根据第二个元素找第一个元素
                return new int[]{map.get(needKey), i};
            }
            // 先比较 后存入map，避免重复元素自比较问题
            map.put(nums[i], i);
        }
        return null;
    }
}
