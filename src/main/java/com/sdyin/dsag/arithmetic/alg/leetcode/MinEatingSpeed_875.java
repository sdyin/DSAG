package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。
 * 如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * @Author: liuye
 * @time: 2023/9/26$ 10:48 上午$
 */
public class MinEatingSpeed_875 {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // 最小速度
        int right = getMax(piles); // 最大速度，即最大堆中的香蕉数

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 可以满足的话，放慢速度，即右边界左移，寻找更慢的数
            if (canEatAll(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 辅助函数：判断是否能在给定速度下吃完所有香蕉
    private boolean canEatAll(int[] piles, int h, int k) {
        int hoursNeeded = 0;
        // 计算每小时k 跟香蕉的话，需要的小时数
        for (int pile : piles) {
            // 技巧：向上取整
            hoursNeeded += (pile + k - 1) / k;
        }
        return hoursNeeded <= h;
    }

    // 辅助函数：计算数组中的最大值
    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
