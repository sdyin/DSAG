package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: leetcode 15.三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/2/11$ 3:49 下午$
 */
public class ThreeSum15 {

    public static void main(String[] args) {
        int[] nums = {-8, -4, -4, -2, 0, 2, 4, 8};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return list;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    List<Integer> sublist = Arrays.asList(nums[i], nums[left], nums[right]);
                    list.add(sublist);
                    // 去重
                    while (left < right && nums[left+1] == nums[left]){
                        left++;
                    }
                    while (left < right && nums[right-1] == nums[right]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return list;
    }
}
