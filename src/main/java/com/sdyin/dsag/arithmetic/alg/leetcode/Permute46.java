package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @Author: liuye
 * @time: 2022/4/19$ 7:39 下午$
 */
public class Permute46 {

    //响应
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        //记录走过的路径节点
        final LinkedList<Integer> list = new LinkedList<>();
        final int length = nums.length;
        boolean[] visited = new boolean[length];
        backtrack(nums, list, visited);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> list, boolean[] visited) {
        //结束条件-路径完成
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }

        //下一路径
        for (int i = 0; i < nums.length; i++) {
            //已访问过
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.addLast(nums[i]);

            //继续递归下一节点
            backtrack(nums, list, visited);

            //退出当前节点路径
            visited[i] = false;
            list.removeLast();
        }
    }
}
