package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * @Author: liuye
 * @time: 2022/4/26$ 8:22 下午$
 */
public class KthSmallest230 {

    private List<Integer> list = new ArrayList<>();

    /**
     * 很明显本题求解思路就是二叉树中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        return traverse(root, k);
    }

    /***
     * 递归
     * @param root
     * @param k
     * @return
     */
    private int traverse(TreeNode root, int k) {
        if (root.left != null) {
            final int leftValue = traverse(root.left, k);
            if (leftValue != -1) {
                return leftValue;
            }
        }
        if(list.size() != k-1) {
            list.add(root.val);
        } else {
            return root.val;
        }
        if (root.right != null) {
            int rightValue =traverse(root.right, k);
            if (rightValue != -1) {
                return rightValue;
            }
        }
        return -1;
    }

    private int res = 0;
    private int rank = 0;

    /**
     * 稍微好看一点
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        traverse2(root, k);
        return res;
    }

    private void traverse2(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse2(root.left, k);

        rank++;
        if(rank == k) {
            res = root.val;
            return;
        }

        traverse2(root.right, k);
    }
}
