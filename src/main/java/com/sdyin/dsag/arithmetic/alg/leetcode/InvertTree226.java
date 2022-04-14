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
    public   TreeNode invertTree(TreeNode root) {
        if ( root == null) {
            return root;
        }
        //前序遍历，翻转左右子节点
        //不可以中序遍历，中序会导致，先处理左子节点，再处理当前节点，再处理右节点(此时右节点就是原始节点的左节点,被翻转了)
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
