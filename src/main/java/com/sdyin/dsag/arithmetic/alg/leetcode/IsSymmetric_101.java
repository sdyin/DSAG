package com.sdyin.dsag.arithmetic.alg.leetcode;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * @Author: liuye
 * @time: 2025/5/20$ 14:56$
 */
public class IsSymmetric_101 {

    /**
     * 递归解法
     * 对称二叉树要求：
     * 1. 对称节点值相等
     * 2. 对称节点左子树的左节点和对称节点右子树的右节点对称
     * 3. 对称节点左子树的右节点和对称节点右子树的左节点对称
     * 所以我们可以定义一个递归函数，判断两个节点是否对称。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // 左右节点都为空，对称
        if (left == null && right == null) {
            return true;
        }
        // 左右节点有一个为空，不对称
        if (left == null || right == null) {
            return false;
        }
        // 左右节点值不相等，不对称
        if (left.val != right.val) {
            return false;
        }
        // 子树是否对称，递归比较左子树的左节点和右子树的右节点，以及左子树的右节点和右子树的左节点
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    /**
     * 迭代解法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // 均空继续
            if (left == null && right == null) {
                continue;
            }
            // 左右节点有一个为空，不对称
            if (left == null || right == null) {
                return false;
            }
            // 左右节点值不相等，不对称
            if (left.val != right.val) {
                return false;
            }
            // 按镜像顺序加入子节点, 添加到末尾
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
