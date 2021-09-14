package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * @Author: liuye
 * @time: 2021/9/14$ 5:18 下午$
 */
public class BuildTree106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int index = 0;
        for (int i = 0; i <= inEnd; i++) {
            if (rootVal == inorder[i]){
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;

        root.left = buildTree(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        // 为什么是后序遍历的起点用 postStart + leftSize 而不能用 index？
        // 对于后序遍历 postStart + leftSize - 1 是左子树的最末节点下标，所以右子树起始节点下标为 postStart + leftSize 没问题
        // 为什么不能是index下标呢，对于后序遍历的右子树的起始节点不就是 中序遍历的根节点的下标吗？
        // 这样想的误区在于，在多级子树之后(比如右子树的左子树)，如果节点没有了左子树，index是相对完整树的，所以肯定大于0，而此时右子树的起始节点其实是0(因为父节点没有左子树)，这样有可能越界。
        System.out.println(" postStart + leftSize:"  + (postStart + leftSize));
        System.out.println("index:" + index);
        root.right = buildTree(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
