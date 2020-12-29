package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

    /**
     * 二叉树前序遍历-bfs解法
     * TODO leetcode提交不对？
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversalBfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.push(root);

        while (!deque.isEmpty()){
            TreeNode node = deque.pop();

            list.add(node.val);
            if(node.left != null){
                deque.push(node.left);
            }
            if(node.right != null){
                deque.push(node.right);
            }
        }
        return list;
    }

}

