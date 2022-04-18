package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 * @Author: liuye
 * @time: 2022/4/18$ 5:48 下午$
 */
public class MinDepth111 {

    //bfs 解法
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int min = 0;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            min++;
            List<TreeNode> list = new ArrayList<>();
            while (!deque.isEmpty()) {
                list.add(deque.poll());
            }

            for (TreeNode node: list) {
                if (node.left == null && node.right == null) {
                    return min;
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return min;
    }
}
