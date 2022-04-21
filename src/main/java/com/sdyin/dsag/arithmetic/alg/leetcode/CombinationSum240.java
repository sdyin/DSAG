package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 40. 组合总和 II
 *给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/4/21$ 2:14 下午$
 */
public class CombinationSum240 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //子集包含重复元素
        Arrays.sort(candidates);
        final LinkedList<Integer> list = new LinkedList<>();
        backtrack(candidates, 0, target, list);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, LinkedList<Integer> list) {
        final int sumValue = sumValue(list);
        //目标和匹配
        if (sumValue == target) {
            res.add(new LinkedList<>(list));
            return;
        }
        if (sumValue > target) {
            return;
        }

        //子集问题，从索引start开始
        for (int i = start; i < candidates.length; i++) {
            //子集包含重复元素处理
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            //选择节点
            list.addLast(candidates[i]);

            //递归回溯
            backtrack(candidates, i + 1, target, list);

            //撤销节点
            list.removeLast();
        }
    }

    private int sumValue(List<Integer> list) {
        int sum = 0;
        for (Integer data: list) {
            sum+=data;
        }
        return sum;
    }
}
