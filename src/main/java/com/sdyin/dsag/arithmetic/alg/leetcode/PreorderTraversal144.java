package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 144 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * @Author: liuye
 * @time: 2020/12/29$ 下午8:12$
 */
public class PreorderTraversal144 {

    /**
     * 二叉树前序遍历-dfs解法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalDfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode root) {
        if(root == null){
            return;
        }

        list.add(root.val);
        dfs(list, root.left);
        dfs(list, root.right);
    }

    public List<Integer> list = new ArrayList<>();

    /**
     * dfs 也可以直接用当前方法，配合一个全局变量即可
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal2(root.left);
        preorderTraversal2(root.right);
        return list;
    }

}

