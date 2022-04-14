package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @Author: liuye
 * @time: 2022/4/14$ 11:13 上午$
 */
public class InvertTree226 {

    /**
     * 调换左右节点即可
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if ( root == null) {
            return root;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        return root;
    }
}
