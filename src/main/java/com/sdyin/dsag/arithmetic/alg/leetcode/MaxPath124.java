package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 *
 *
 * 简单理解就是找出累加最大值，最少要有一个节点，只能按照树的连接依次累加。
 *
 * 思路参考：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-30/
 *
 * @Author: liuye
 * @time: 2021/8/15$ 4:29 下午$
 */
public class MaxPath124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max(root);
        return max;
    }

    public int max(TreeNode root) {
        if (root == null){
            return 0;
        }
        //左子树最大值
        final int leftMax = Math.max(0, max(root.left));
        //右子树最大值
        final int rightMax = Math.max(0, max(root.right));

        //根节点加上最大左右子树值(左右子树最大值最小是0) 与历史最大值比较，然后取大的替换历史最大值
        max = Math.max(this.max, root.val + leftMax + rightMax);

        //经过root节点，然后加上最大左子树或者右子树(最小为0)，只加一个是因为要再递归给父节点使用。
        return root.val + Math.max(leftMax, rightMax);
    }
}
