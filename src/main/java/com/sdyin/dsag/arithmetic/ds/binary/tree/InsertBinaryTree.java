package com.sdyin.dsag.arithmetic.ds.binary.tree;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;

/**
 * @Description 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 * @Author liuye
 * @Date 2020/9/30 9:42
 **/
public class InsertBinaryTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){
            return new TreeNode(val);
        }
        int rootVal = root.val;


        if(rootVal < val){
            if(root.right != null){
                insertIntoBST(root.right, val);
            }else{
                TreeNode node = new TreeNode(val);
                root.right = node;
            }
        }

        if(rootVal > val){
            if(root.left != null){
                insertIntoBST(root.left, val);
            }else{
                TreeNode node = new TreeNode(val);
                root.left = node;
            }
        }
        return root;
    }
}
