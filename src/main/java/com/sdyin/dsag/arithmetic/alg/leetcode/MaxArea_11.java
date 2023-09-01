package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * @Author: liuye
 * @time: 2023/9/1$ 6:43 上午$
 */
public class MaxArea_11 {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            // 当前面积
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            // 移动较小的指针
            // 为什么这里可以移动较小的指针呢？
            // 计算面积时，高度是两个指针中最小的那个，如果向内移动较大的指针，那么面积一定会变小，因为高度还是较小的那个，而宽度变小了
            // 向内移动较小的指针，才有可能使面积变大
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

}
