package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 669. 修剪二叉搜索树
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
 * 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。
 * 可以证明，存在唯一的答案。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 * @Author: liuye
 * @time: 2022/4/14$ 9:47 下午$
 */
public class TrimBST669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        //当前节点小于最小值，删除左子树
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        //当前节点大于最大值，删除右子树
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        //区间内则不移除
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
