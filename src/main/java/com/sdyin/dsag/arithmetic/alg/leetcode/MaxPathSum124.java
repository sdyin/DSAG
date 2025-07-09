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

    /**
     * 返回值：是从当前 node 出发的单边最大贡献值，也就是 node.val + max(left, right)
     * 全局变量res： 记录的是经过当前这个节点， 同时连上了它的左子树的一条路径和它的右子树的一条路径，形成一个「完整的路径段」的最大值
     *
     * 也就是该方法的返回值，是当前节点的最大贡献值，也就是单边最大路径！！！ 但是全局变量res记录的是当前节点的最大路径和！！
     * @param root
     * @return
     */
    private int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归左右节点，小于0时不选择则值为0
        int left = Math.max(0, max(root.left));
        int right = Math.max(0, max(root.right));
        //后序遍历位置: 最大值
        // 当前节点的最大路径和 = 左 + 右 + 当前节点，即left + right + root.val
        res = Math.max(res, left + right + root.val);
        //重点：返回当前节点对上层的最大贡献值（只能选一边）
        return root.val + Math.max(left, right);
    }
}
