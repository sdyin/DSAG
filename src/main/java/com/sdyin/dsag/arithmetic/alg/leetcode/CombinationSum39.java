package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 39. 组合总和
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 * @Author: liuye
 * @time: 2022/4/21$ 3:08 下午$
 */
public class CombinationSum39 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        LinkedList<Integer> list = new LinkedList<>();
        backtrace(candidates, 0, target, list);
        return res;
    }

    private void backtrace(int[] candidates, int index, int target, LinkedList<Integer> list) {
        final int sumValue = sumValue(list);
        //匹配到目标元素，添加
        if (sumValue == target) {
            res.add(new LinkedList<>(list));
            return;
        }
        //已大于目标元素，不满足直接return
        if (sumValue > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            //选择添加节点路径
            list.addLast(candidates[i]);

            //递归添加,因为每个元素可以重复使用，所以这里仍然是i 而不是i+1
            backtrace(candidates, i, target, list);

            //撤销选择
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
