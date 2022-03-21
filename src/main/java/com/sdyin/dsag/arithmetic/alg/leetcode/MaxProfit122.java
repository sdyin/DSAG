package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 122. 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中prices[i] 表示股票第 i 天的价格。
 * <p>
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/3/22$ 12:14 上午$
 */
public class MaxProfit122 {


    public int maxProfit(int[] prices) {
        int length = prices.length;
        int max = 0;
        if (length <= 1) {
            return max;
        }
        //和炒股一样，只要第二天价格比第一天价格高，就可以买入，如果低就不买，也就是贪心的思想
        for (int i = 1; i < length; i++) {
            if (prices[i] > prices[i - 1]) {
                max = max + (prices[i] - prices[i - 1]);
            }
        }
        return max;
    }
}
