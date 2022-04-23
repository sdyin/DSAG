package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 354. 俄罗斯套娃信封问题
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 注意：不允许旋转信封。
 *
 * 示例 1：
 *
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * @Author: liuye
 * @time: 2022/4/23$ 11:05 下午$
 */
public class MaxEnvelopes354 {

    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        final int i = maxEnvelopes(envelopes);
        System.out.println(i);
    }

    /**
     * leetcode 超时，待验证
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(e -> e[0]));

        final int length = envelopes.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        //base case
        dp[0] = 1;
        for (int i = 0; i < envelopes.length; i++) {
            int[] cur = envelopes[i];
            for (int j = 0; j < i; j++) {
                int[] pre = envelopes[j];
                if (cur[0] > pre[0] && cur[1] > pre[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] < dp[i - 1]) {
                dp[i] = dp[i - 1];
            }
        }
        return dp[length - 1];
    }

    /**
     * 另一种思路，我们先把二维数组按照 宽度排序，如果宽度相同，再按照高度逆序。
     * 这个时候再在高度上求最长递增子序列，即是题解。
     * 具体流程图解可参考： https://labuladong.github.io/algo/3/24/77/
     * @param envelopes
     * @return
     */
    public int maxEnvelopes2(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        //取出高度
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //初始化，每个元素最小递增子序列是1
        Arrays.fill(dp, 1);
        //base case
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            //计算每个节点之前比自己小的元素总和
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] < dp[i-1]) {
                dp[i] = dp[i-1];
            }
        }
        return dp[nums.length - 1];
    }
}
