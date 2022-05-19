package com.sdyin.dsag.arithmetic.alg.leetcode;

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
}
