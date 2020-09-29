package com.sdyin.dsag.arithmetic.ds.binary.tree;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;

/**
 * @Description 105.根据前序和中序遍历构造二叉树
 * @Author liuye
 * @Date 2020/9/29 9:48
 **/
public class BuildTreeByPreAndInOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode rootNode = new TreeNode(rootVal);
        int index = 0;

        for (int j = 0; j < inorder.length; j++) {
            if (inorder[j] == rootVal) {
                index = j;
                break;
            }
        }
        //左子树长度
        int leftSize = index - inStart;

        //构造左右子树
        // 前序遍历左子树起点: preStart + 1
        // 前序遍历左子树终点: preStart + leftSize
        // 中序遍历左子树起点: inStart
        // 中序遍历左子树终点: index - 1
        rootNode.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder,  inStart, index - 1);

        // 前序遍历右子树起点: preStart + leftSize + 1
        // 前序遍历右子树终点: preEnd
        // 中序遍历右子树起点: index + 1
        // 中序遍历右子树终点: inEnd
        rootNode.right = buildTree( preorder,  preStart + leftSize + 1,preEnd, inorder, index  + 1,inEnd);

        return rootNode;
    }
}
