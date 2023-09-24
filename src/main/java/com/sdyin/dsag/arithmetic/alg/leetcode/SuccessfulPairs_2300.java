package com.sdyin.dsag.arithmetic.alg.leetcode;

import com.google.common.collect.Lists;
import net.bytebuddy.dynamic.TargetType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 2300. 咒语和药水的成功对数
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，
 * 其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 * @Author: liuye
 * @time: 2023/9/24$ 2:32 下午$
 */
public class SuccessfulPairs_2300 {

    /**
     * 测试用例未完全通过
     *
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int spellValue = spells[i];
            int targetValue = (int) success / spellValue;
            // 还有余数，目标值自增
            if (success % spellValue != 0) {
                targetValue++;
            }

            int size = matchNumSize(potions, targetValue);
            list.add(size);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int matchNumSize(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                result = nums.length - mid; // 更新结果为剩余元素的个数
                right = mid - 1; // 继续在左半部分查找
            } else {
                left = mid + 1; // 在右半部分查找
            }
        }
        return result;
    }


    /**
     * 解法通过
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public int[] successfulPairs2(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            // 计算目标值，向上取整
            // 这是一个常用的向上取整的技巧：如果你有一个需要向上取整的除法a / b，你可以改写成(a + b - 1) / b。
            // 这样做的原因是，如果a可以被b整除，那么结果就是a / b；
            // 如果a不能被b整除，那么结果就是a / b + 1，这就实现了向上取整的效果。
            long target = (success + spells[i] - 1) / spells[i];
            int index = binarySearch(potions, target); // 二分查找
            result[i] = potions.length - index; // 计算成功组合的数量
        }

        return result;
    }

    private int binarySearch(int[] potions, long target) {
        int left = 0, right = potions.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (potions[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
