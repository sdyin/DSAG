package com.sdyin.dsag.arithmetic.alg.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）
 *
 * @Author liuye
 * @Date 2020/7/31 16:22
 **/
public class TriangleMinPath {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        //第一行只有一个值为当前值
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            //当j = 0 时，dp[i][j] = dp[i-1][j] + value[i][j]
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                //dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + value[i][j]
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            //当i=j时， dp[i][j] = dp[i-1][j-1] + value[i][j]
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = dp[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, dp[n - 1][i]);
        }
        return minTotal;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1);
        List<Integer> list2 = Arrays.asList(3,5);
        List<Integer> list3 = Arrays.asList(2,6,3);
        List<Integer> list4 = Arrays.asList(3,1,5,3);
        List<Integer> list5 = Arrays.asList(8,7,9,3,7);
        List list = new ArrayList();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);
        int i = minimumTotal(list);
        System.out.println(i);
    }
}
