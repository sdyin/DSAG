package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.LinkedList;

/**
 * @Description: 1161. 最大层内元素和
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * @Author: liuye
 * @time: 2023/9/12$ 12:40 下午$
 */
public class MaxLevelSum_1161 {

    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        // 标记当前遍历层数
        int layer = 0;
        // 目标层数
        int targetLayer = 0;
        int maxSum = Integer.MIN_VALUE;

        while (deque.size() > 0) {
            layer++;
            int sum = 0;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                int value = node.val;
                sum += value;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            if (sum > maxSum) {
                targetLayer = layer;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return targetLayer;
    }
}
