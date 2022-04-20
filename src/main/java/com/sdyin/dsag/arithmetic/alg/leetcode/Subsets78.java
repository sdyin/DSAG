package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * @Author: liuye
 * @time: 2022/4/20$ 7:46 下午$
 */
public class Subsets78 {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(nums, 0, list);
        return res;
    }

    private static void backtrack(int[] nums, int index, LinkedList<Integer> list) {
        //添加集合路径
        //此处不用判断是因为节点路径不会向后添加
        res.add(new LinkedList<>(list));

        //回溯算法标准框架解法
        for (int i = index; i < nums.length; i++) {
            //添加节点,因为本身有序，不会回头添加，所以节点均可添加
            int num = nums[i];
            list.addLast(num);

            //递归添加
            //注意，这里第二个参数千万不能写成index+1,
            //为什么呢？ 因为i的值与index不恒相等，只有经过在for循环初始赋值，i和index才相等。后续递归过程会不一致。因为有可能for循环过程中i++ 而index不变
            //这里是i+1 就是取子集，如果仍从0开始就是全排列
            backtrack(nums, i + 1, list);

            //撤销节点
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        subsets(nums);
    }
}
