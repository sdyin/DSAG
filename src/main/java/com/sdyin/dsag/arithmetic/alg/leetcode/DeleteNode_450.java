package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * 提示:
 *
 * 节点数的范围 [0, 104].
 * -105 <= Node.val <= 105
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 105
 *
 * @Author: liuye
 * @time: 2023/9/13$ 2:26 下午$
 */
public class DeleteNode_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        root = deleteTreeNode(root, key);
        return root;
    }

    private TreeNode deleteTreeNode(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        //节点匹配中目标值
        if (node.val == key) {
            // 没有子节点，直接删除当前节点
            if (node.left == null && node.right == null) {
                return null;
            }
            // 左节点为空或右节点存在一个
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            // 左右节点均存在
            if (node.left != null && node.right != null) {
                // 这种场景，需要找到左子树最大的节点或者右子树最小的节点，替换掉当前节点。
                // 当前我们选用右子树最小的节点
                TreeNode minNode = findMin(node.right);
                // 替换当前节点
                node.val = minNode.val;
                // 删除该右子树最小节点
                node.right = deleteTreeNode(node.right, minNode.val);
            }
        }
        // 节点值小于目标值
        if (node.val < key) {
            node.right = deleteTreeNode(node.right, key);
        }
        // 节点值大于目标值
        if (node.val > key) {
            node.left = deleteTreeNode(node.left, key);
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
