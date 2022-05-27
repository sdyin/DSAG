package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 114.二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @Author: liuye
 * @time: 2022/4/14$ 11:26 上午$
 */
public class Flatten114 {

    // 分解方式解决问题
    // 定义：将以 root 为根的树拉平为链表
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten2(root.left);
        flatten2(root.right);

        //后序遍历位置处理(是为了从底部开始处理，自底向上)
        TreeNode left = root.left;
        TreeNode right = root.right;
        //左子树作为右子树
        root.left = null;
        root.right = left;
        //这里要循环，因为当前右子树可能有多个节点，所以一定要递归到右子树最后一个节点，再来拼接原有右子树
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }






    static TreeNode node = new TreeNode(-1);
    //1.遍历方式解决问题
    public static  void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode dummy = node;
        expand(root);
        root = dummy.right;
    }

    private static void expand(TreeNode root) {
        if (root == null) {
            return;
        }
        node.right = new TreeNode(root.val);
        node = node.right;

        expand(root.left);
        expand(root.right);

    }

    public static void main(String[] args) {
        final TreeNode treeNode3 = new TreeNode(3);
        final TreeNode treeNode4 = new TreeNode(4);
        final TreeNode treeNode6 = new TreeNode(6);

        final TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        final TreeNode treeNode5 = new TreeNode(5);
        treeNode5.right = treeNode6;

        final TreeNode treeNode = new TreeNode(1);
        treeNode.left = treeNode2;
        treeNode.right = treeNode5;

        flatten(treeNode);
    }
}
