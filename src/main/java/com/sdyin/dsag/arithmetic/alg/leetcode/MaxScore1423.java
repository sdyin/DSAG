package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 1423. 可获得的最大点数
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * <p>
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * <p>
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * <p>
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2021/2/6$ 下午7:25$
 */
public class MaxScore1423 {

    /**
     * 滑动窗口解法：最后剩余的一定是 length - k 个连续的数，求得剩余数和最小即得到了拿到的最大的数。
     *
     * @param cardPoints
     * @param k
     * @return
     */
    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int min = 0;
        int temp = 0;
        int length = cardPoints.length;
        for (int i = 0; i < length; i++) {
            sum += cardPoints[i];
            if (i < length - k) {
                min += cardPoints[i];
                temp += cardPoints[i];
                continue;
            } else {
                temp = temp + cardPoints[i] - cardPoints[i - (length - k)];
            }
            min = Math.min(min, temp);
        }
        return sum - min;
    }

    public static void main(String[] args) {
        int[] a = {2,2,2};
        int k = 2;
        final int result = maxScore(a, k);
        System.out.println(result);
    }
}
