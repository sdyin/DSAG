package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description:
 * leetcode 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 提示：
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 * @Author: liuye
 * @time: 2025/7/1$ 15:28$
 */
public class FirstMissingPositive41 {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 第一次遍历：将每个正整数放到它应该在的位置上
        // nums[nums[i] - 1] 解释： nums[i] 表示当前元素的值，nums[i] - 1 表示当前元素应该在的位置。
        // 例如，nums[i] = 3，那么 nums[i] - 1 = 2，即当前元素应该在数组的第 3 个位置（索引为 2）。
        // 所以，nums[nums[i] - 1] 表示当前元素应该在的位置上的值。
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 第二次遍历：找到第一个位置不正确的数
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果所有位置都正确，返回n+1
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
