package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode222.完全二叉树的节点个数
 * //给出一个完全二叉树，求出该树的节点个数。
 * //
 * // 说明：
 * //
 * // 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
 * //第 h 层，则该层包含 1~ 2h 个节点。
 * //
 * // 示例:
 * //
 * // 输入:
 * //    1
 * //   / \
 * //  2   3
 * // / \  /
 * //4  5 6
 * //
 * //输出: 6
 * // Related Topics 树 二分查找
 * // 👍 306 👎 0
 * @Author: liuye
 * @time: 2020/11/24$ 上午9:57$
 */
public class CountNodes222 {

    private static int sum = 0;

    public static int countNodes(TreeNode root) {
        int count = recursionNode(root);
        return count;
    }

    private static int recursionNode(TreeNode root) {
        if (root == null) {
            return sum;
        }
        sum++;
        if(root.left != null){
            recursionNode(root.left);
        }
        if(root.right != null){
            recursionNode(root.right);
        }
        return sum;
    }

    public static void main(String[] args) {
         TreeNode treeNode = new TreeNode(1);
         TreeNode left = new TreeNode(2);
         TreeNode right = new TreeNode(3);
         treeNode.left = left;
         treeNode.right = right;
        final int i = countNodes(treeNode);
        System.out.println(i);
    }
}
