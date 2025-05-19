package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.LinkedList;

/**
 * @Description: 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @Author: liuye
 * @time: 2022/5/19$ 10:32 下午$
 */
public class MaxDepth104 {

    /**
     * 深度优先 递归解法
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int max = 0;
        max = getMax(root, max);
        return max;
    }

    /**
     * dfs解法
     *
     * @param root
     * @param max
     * @return
     */
    private int getMax(TreeNode root, int max) {
        if (root == null) {
            return max;
        }
        max++;
        int leftMax = getMax(root.left, max);
        int rightMax = getMax(root.right, max);
        return Math.max(leftMax, rightMax);
    }

    /***
     * 广度优先 迭代解法
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int deep = 0;
        while (!list.isEmpty()) {
            // 每次循环遍历一层节点
            deep++;
            int size = list.size();
            // 每次取出一层的节点
            for (int i = 0; i < size; i++) {
                // 从队首取出节点
                TreeNode node = list.poll();
                if (node.left != null) {
                    // 从队尾添加，保证每次取出的都是同一层的节点
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
        }
        return deep;
    }
}
