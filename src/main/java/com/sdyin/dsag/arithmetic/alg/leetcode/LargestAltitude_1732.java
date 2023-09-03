package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 1732. 找到最高海拔
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由n + 1个不同海拔的点组成。
 * 自行车手从海拔为 0的点0开始骑行。
 * <p>
 *  给你一个长度为 n的整数数组gain，其中 gain[i]是点 i和点 i + 1的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
 *
 *  提示：
 *  n == gain.length
 *  1 <= n <= 100
 *  -100 <= gain[i] <= 100
 * @Author: liuye
 * @time: 2023/9/3$ 3:15 下午$
 */
public class LargestAltitude_1732 {

    public int largestAltitude(int[] gain) {
        int maxHigh = Integer.MIN_VALUE;
        int high = 0;
        // 循环一次得到每个节点的海拔
        for (int i = 0; i < gain.length; i++) {
            high += gain[i];
            maxHigh = Math.max(maxHigh, high);
        }
        // 因为从海拔0开始骑行，所以最初海拔是0，即最低海拔是0
        return maxHigh < 0 ? 0 : maxHigh;
    }

}
