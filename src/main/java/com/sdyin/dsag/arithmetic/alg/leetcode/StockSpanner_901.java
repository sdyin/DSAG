package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Stack;

/**
 * @Description: 901. 股票价格跨度
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 *
 * 实现 StockSpanner 类：
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 * 示例：
 * 输入：
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 输出：
 * [null, 1, 1, 1, 2, 1, 4, 6]
 * 解释：
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // 返回 1
 * stockSpanner.next(80);  // 返回 1
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(70);  // 返回 2
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(75);  // 返回 4，因为价格跨度为 4 的最后 4 个价格（包括今天的价格
 * stockSpanner.next(85);  // 返回 6
 * 提示：
 * 1 <= price <= 105
 * 每一天的价格都是不同的。
 * 每一个测试用例最多可以调用  10000 次 StockSpanner.next。
 * 通过次数7,000提交次数12,000
 *
 * @Author: liuye
 * @time: 2023/11/23$ 2:38 下午$
 */
public class StockSpanner_901 {

    // 单调栈, 栈中的元素是一个整形数组对（价格，跨度）
    // 单调递减的栈，栈顶元素最小
    private Stack<int[]> stack;

    public StockSpanner_901() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        // 栈不为空，且当前元素大于等于栈顶元素，则栈顶出栈
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            //跨度为当前跨度 + 栈顶元素的跨度
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        StockSpanner_901 stockSpanner = new StockSpanner_901();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
