package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @Author: liuye
 * @time: 2022/4/14$ 11:13 上午$
 */
public class InvertTree226 {

    /**
     * 遍历递归的思路： 调换左右节点即可
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
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

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeRe(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.right = invertTree(leftNode);
        root.left = invertTree(rightNode);

        return root;
    }

    /**
     * 分解问题的思路
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 利用函数定义，先翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 然后交换左右子节点
        root.left = right;
        root.right = left;

        // 和定义逻辑自恰：以 root 为根的这棵二叉树已经被翻转，返回 root
        return root;
    }
}
