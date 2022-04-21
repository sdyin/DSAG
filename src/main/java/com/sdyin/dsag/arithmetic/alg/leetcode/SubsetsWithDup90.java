package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * @Author: liuye
 * @time: 2021/3/31$ 下午5:33$
 */
public class SubsetsWithDup90 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先排序 保证相同的元素相邻
        Arrays.sort(nums);
        final LinkedList<Integer> list = new LinkedList<>();
        backtrack(nums, 0, list);
        return res;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> list) {
        res.add(new LinkedList<>(list));

        //子集问题，i起点为index
        for (int i = start; i < nums.length; i++) {
            //nums[i] == nums[i-1]: 集合中有重复元素,需要跳过
            //i > start：初始调用for循环和for循环中自己循环场景区分
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            //添加节点
            list.addLast(nums[i]);
            //递归调用
            backtrack(nums, i + 1, list);
            //撤销节点
            list.removeLast();
        }
    }
}
