package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * @Author: liuye
 * @time: 2023/10/7$ 5:36 下午$
 */
public class CombinationSum3_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        // 目标结果集
        List<List<Integer>> result = new ArrayList<>();
        // 当前结果集
        List<Integer> currentCombination = new ArrayList<>();
        findCombinations(k, n, 1, result, currentCombination);
        return result;
    }

    /**
     * 递归回溯方法
     *
     * @param k 目标数量
     * @param target 目标和
     * @param start 起始数
     * @param result 目标结果集
     * @param currentCombination 当前结果集
     */
    private void findCombinations(int k, int target, int start, List<List<Integer>>  result, List<Integer> currentCombination) {
        // 满足，添加当前结果集到目标结果集
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // 不满足
        if (k == 0 || target <= 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            // 添加当前数据到结果集
            currentCombination.add(i);
            // 递归调用
            findCombinations(k - 1, target - i, i + 1, result, currentCombination);
            // 回溯撤销该元素
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
