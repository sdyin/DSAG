package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * @Author: liuye
 * @time: 2022/4/28$ 9:08 下午$
 */
public class MaxPathSum124 {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max(root);
        return res;
    }

    private int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归左右节点，小于0时不选择则值为0
        int left = Math.max(0,maxPathSum(root.left));
        int right = Math.max(0,maxPathSum(root.right));
        //后序遍历位置: 最大值
        res = Math.max(res, left + right + root.val);
        //返回包含父节点的左子树或右子树,因为路径节点在一条路径序列中，至多出现一次
        return root.val + Math.max(left, right);
    }
}
