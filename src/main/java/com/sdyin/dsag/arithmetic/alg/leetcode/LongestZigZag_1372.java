package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 1372. 二叉树中的最长交错路径
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * 请你返回给定树中最长 交错路径 的长度。
 *
 * @Author: liuye
 * @time: 2023/9/10$ 11:30 下午$
 */
public class LongestZigZag_1372 {

    int max = 0;

    /**
     * 这是一个关于二叉树深度优先搜索（DFS）的问题。
     * 可以使用递归来解决这个问题。
     * 需要跟踪两个变量：左子树的最长交错路径和右子树的最长交错路径。
     * 然后，更新全局最大值，并返回当前节点的最长交错路径。
     * @param root
     * @return
     */
    public int longestZigZag(TreeNode root) {
        // 初始长度为0，初始isLeft 向左和向右一样，递归过程左右节点都会遍历
        dfs(root, true, 0);
        return max;
    }

    /**
     * @param node 当前节点
     * @param isLeft 上一步是否向左移动
     * @param length 以及当前路径的长度
     */
    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) {
            return;
        }
        max = Math.max(max, length);
        // 针对第三个参数，如果上一步已经向左移动，还要向左移动，就从1计数(从开始计数)， 反之则计数累加
        dfs(node.left, true, isLeft ? 1 : length + 1);
        dfs(node.right, false, isLeft ? length + 1 : 1);
    }
}
