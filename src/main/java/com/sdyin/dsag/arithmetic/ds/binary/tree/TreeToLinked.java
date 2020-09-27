package com.sdyin.dsag.arithmetic.ds.binary.tree;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @Description 114.二叉树展开为单链表
 * 给定一个二叉树，原地将它展开为一个单链表。注意，是拉平成一颗单链表的树，不是返回一个链表
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * @Author liuye
 * @Date 2020/9/27 17:02
 **/
public class TreeToLinked {

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        flatten(root.left);

        flatten(root.right);

        /* TODO 错误原因暂未确定
        if(root.left == null){
            return;
        }
        if(root.right == null){
            root.right = root.left;
            root.left = null;
            return;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.right = left;
        root.left = null;


        while(left.right != null){
            left = left.right;
        }
        left.right = right;
        root.right = left;*/


        TreeNode left = root.left;
        TreeNode right = root.right;

        //将左子树作为右子树
        root.left = null;
        root.right = left;

        //右子树转移到左子树(左子树右侧)的后侧
        while(root.right != null){
            //循环得到最下叶子节点
            root = root.right;
        }
        root.right = right;

    }
}
