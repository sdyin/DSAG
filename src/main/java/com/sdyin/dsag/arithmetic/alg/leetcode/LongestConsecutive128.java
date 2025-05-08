package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description: 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 解释：最长数字连续序列是 [0, 1, 2, 3, 4, 5, 6, 7, 8]。它的长度为 9。
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 * @Author: liuye
 * @time: 2025/5/8$ 13:14$
 */
public class LongestConsecutive128 {

    /**
     * 常规方式： 先排序后循环递增比较
     * 时间复杂度：O(nlogn)
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i] + 1 == nums[i + 1]) {
                count++;
                res = Math.max(res, count);
                continue;
            }
            count = 1;
        }
        return res;
    }

    /**
     * 使用HashSet 容器，时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        // 使用HashSet自动去重，避免重复计算
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        return numSet.stream()
                // 序列起点判断：只有当num-1不存在时才作为起点，确保每个序列只被处理一次
                .filter(num -> !numSet.contains(num - 1))
                .mapToInt(num -> {
                    int current = num;
                    while (numSet.contains(current + 1)) current++;
                    return current - num + 1;
                })
                .max()
                .orElse(0);
    }
}
