package com.sdyin.dsag.arithmetic.alg.dfs;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;

import java.util.ArrayDeque;

/**
 * @Description: 104.二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * @Author: liuye
 * @time: 2022/3/19$ 2:10 下午$
 */
public class TreeMaxDeep {

    public int maxDepth(TreeNode root) {
        //int deep = dfs(root, 0);
        int deep = bfs(root);
        return deep;
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    private int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayDeque deque = new ArrayDeque<>();
        deque.offer(root);

        int deep = 0;
        while (deque.size() != 0) {
            ++deep;
            int size = deque.size();
            //添加当前元素，添加子元素
            while (size > 0){
                TreeNode node = (TreeNode) deque.pop();
                if (node.left != null) {
                    deque.offer(node.left);
                }

                if (node.right != null) {
                    deque.offer(node.right);
                }
                size--;
            }
        }
        return deep;
    }

    /**
     * 深度优先遍历
     *
     * @param node
     * @param i
     * @return
     */
    private int dfs(TreeNode node, int i) {
        if (node == null) {
            return i;
        }
        ++i;
        return Math.max(dfs(node.left, i), dfs(node.right, i));
    }


}
