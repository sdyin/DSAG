package com.sdyin.dsag.arithmetic.alg.leetcode;

import lombok.val;
import org.checkerframework.checker.units.qual.K;
import sun.security.krb5.internal.crypto.Aes128;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Description 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * @Author liuye
 * @Date 2020/9/26 15:36
 **/
public class PathSum2 {

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }


    private void dfs(TreeNode root, int sum) {
        if(root == null){
            return;
        }
        sum -= root.val;
        path.offerLast(root.val);
        if(root.left == null && root.right == null && 0 == sum){
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        //删除该节点，即删除非叶子节点
        path.pollLast();
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
