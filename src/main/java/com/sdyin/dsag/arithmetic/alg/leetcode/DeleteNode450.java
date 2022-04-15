package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * @Author: liuye
 * @time: 2022/4/15$ 11:57 上午$
 */
public class DeleteNode450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        //匹配到目标值时
        if (root.val == key) {
            //1.左右节点均为空
            if (root.left == null && root.right == null) {
                return null;
            }
            //2.左右节点有一个为空时
            if (root.left == null){
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //左右节点都不为空
            if (root.left != null && root.right != null) {
                //找到左子树最大值,因为是BST，所以最大值肯定是叶子节点。(这里也可以找右子树最小值)
                TreeNode leftMaxNode = getLeftMax(root.left);
                //删除该左子树最大节点
                final TreeNode left = deleteNode(root.left, leftMaxNode.val);

                leftMaxNode.right = root.right;
                leftMaxNode.left = left;
                root  = leftMaxNode;
            }
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getLeftMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
