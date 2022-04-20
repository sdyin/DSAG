package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * @Author: liuye
 * @time: 2022/4/20$ 11:49 下午$
 */
public class Combine77 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> list =new LinkedList<>();
        backtrack(n, k,1, list);
        return res;
    }

    private void backtrack(int n, int k, int index, LinkedList<Integer> list) {
        if (list.size() == k) {
            res.add(new LinkedList<>(list));
        }

        //回溯算法解决问题框架之一
        for (int i = index; i <= n; i++) {
            //加入节点路径
            list.addLast(i);

            //继续递归添加
            backtrack(n, k, i + 1, list);

            //撤销节点
            list.removeLast();
        }
    }
}
