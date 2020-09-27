package com.sdyin.dsag.arithmetic.ds.binary.tree;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 226.翻转二叉树
 * 示例： 输入
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @Author liuye
 * @Date 2020/9/27 10:56
 **/
public class FlipTree {

    public TreeNode invertTree(TreeNode root) {
        recursive(root);
        return root;
    }

    /**
     * 递归方式翻转二叉树
     *
     * @param root
     */
    private void recursive(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        recursive(root.left);
        recursive(root.right);
    }

    public TreeNode invertTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return root;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right != null){
                queue.offer(root.right);
            }
        }
        return root;
    }


}
