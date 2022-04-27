package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 * @Author: liuye
 * @time: 2021/9/14$ 8:09 上午$
 */
public class BuildTree105 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //下标从0开始，所以尾节点为 length - 1
        final TreeNode treeNode = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return treeNode;
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //判断边界
        if(preStart > preEnd){
            return null;
        }
        //标识根节点在中序遍历中下标索引处
        int index = 0;
        int rootVal =  preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        //遍历获取左子树长度
        for (int i = inStart; i <= inEnd; i++) {
            if(rootVal == inorder[i]){
                index = i;
                break;
            }
        }

        //左子树长度，不要想当然就以为preStart + leftSize 一直等于 index
        int leftSize = index - inStart;

        // 构造左子树
        // 前序遍历左子树起点: preStart + 1
        // 前序遍历左子树终点: preStart + leftSize
        // 中序遍历左子树起点: inStart
        // 中序遍历左子树终点: index - 1
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);

        // 构造右子树
        // 前序遍历右子树起点: preStart + leftSize + 1
        // 前序遍历右子树终点: preEnd
        // 中序遍历右子树起点: index + 1
        // 中序遍历右子树终点: inEnd
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);

        return root;
    }


}
