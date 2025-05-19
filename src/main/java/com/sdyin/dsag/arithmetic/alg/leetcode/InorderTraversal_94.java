package com.sdyin.dsag.arithmetic.alg.leetcode;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @Author: liuye
 * @time: 2025/5/19$ 10:11$
 */
public class InorderTraversal_94 {

    /**
     * 迭代解法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 不断将左子节点压入栈
            while (current != null) {
                // 压入队首
                stack.push(current);
                current = current.left;
            }
            // 弹出栈顶节点访问，该节点相当于父节点
            current = stack.pop();
            list.add(current.val);
            // 转向右子节点
            current = current.right;
        }
        return list;
    }

    private List<Integer> list = new ArrayList<>();

    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return list;
        }
        recursion(root);
        return list;
    }

    private void recursion(TreeNode node) {
        if (node.left != null) {
            recursion(node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            recursion(node.right);
        }
    }
}
