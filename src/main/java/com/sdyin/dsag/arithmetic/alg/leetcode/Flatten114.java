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

    // 分解方式解决问题(递归)
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
        // 原左子树拼接完毕后，左子树接回右子树
        p.right = right;
    }


    /**
     * 迭代方式求解
     *
     * @param root
     */
    public static  void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                // 找到当前节点 curr 左子树的最右侧节点（即左子树中最后一个会被前序遍历到的节点）
                TreeNode pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                // 这个节点是 curr 左子树的“前驱节点”，在展开后的链表中，它应该指向 curr 的原始右子树。
                // 将右子树挂到前驱节点的右侧
                pre.right = curr.right;

                // 移动左子树到右子树位置
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
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
