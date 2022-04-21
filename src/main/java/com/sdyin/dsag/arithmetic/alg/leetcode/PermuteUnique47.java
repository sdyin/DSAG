package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * @Author: liuye
 * @time: 2022/4/21$ 9:23 上午$
 */
public class PermuteUnique47 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, list);
        return res;
    }

    private void backtrack(int[] nums, boolean[] visited, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }

        //全排列
        for (int i = 0; i < nums.length; i++) {
            //已访问过，跳过此次循环
            if(visited[i]) {
                continue;
            }

            //相邻元素重复场景过滤
            // !visited[i-1] 也就是 i-1 索引的元素没有访问过，没有访问过则跳过，
            // 实际上是为了保证i-1 和 i 的访问顺序，i-1 和 i 索引处元素相同时，保证i-1 在 i前面访问(去重)
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }

            //标记当前索引已访问过
            visited[i] = true;
            //添加节点路径
            list.addLast(nums[i]);

            //递归调用
            backtrack(nums, visited, list);

            //撤销节点
            visited[i] = false;
            list.removeLast();
        }
    }
}
