package com.sdyin.dsag.arithmetic.alg.leetcode;

import com.sdyin.dsag.arithmetic.ds.binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * leetcode 102 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * @Author: liuye
 * @time: 2025/5/22$ 11:43$
 */
public class LevelOrder_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 从队头取出元素
                TreeNode node = queue.poll();
                list.add(node.val);
                // 添加到队尾
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right!= null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
