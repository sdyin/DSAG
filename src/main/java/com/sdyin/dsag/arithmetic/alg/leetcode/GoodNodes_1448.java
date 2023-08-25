package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 1448. 统计二叉树中好节点的数目
 *
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * @Author: liuye
 * @time: 2023/8/25$ 11:07 上午$
 */
public class GoodNodes_1448 {

    private int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    /**
     * dfs 深度优先搜索
     * 因为每次都要比对从根节点出发是否比之前所有路径节点大，所以参数传入之前节点的最大值
     * @param root
     * @param val
     */
    private void dfs(TreeNode root, int val) {
        if (root.val >= val) {
            count++;
        }
        if (root.left != null) {
            dfs(root.left, Math.max(root.val, val));
        }
        if (root.right != null) {
            dfs(root.right, Math.max(root.val, val));
        }
    }
}
