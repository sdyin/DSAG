package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description:
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 *
 * @Author: liuye
 * @time: 2025/5/11$ 17:01$
 */
public class Trap42 {

    public int trap(int[] height) {
        int length = height.length;
        if (length < 2) {
            return 0;
        }
        // 初始化左右指针
        int left = 0, right = length - 1;
        // 记录左右两边的最大高度
        int leftMax = 0, rightMax = 0;
        // 存储总积水量
        int res = 0;

        // 思路上两侧使用双指针还是一列一列的移动，比较左右侧节点高度，取较小值，减去当前当前高度，就是当前节点的积水量
        // 细节点：如果左右指针最大高度是当前自己的节点，则不计算积水量，因为无法接雨水
        while (left < right) {
            // 动态更新左右最大值
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // 决定移动哪边的指针
            if (height[left] < height[right]) {
                // 计算累积左边积水量
                res += leftMax - height[left];
                left++;
            } else {
                // 计算累积右边积水量
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
