package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description: leetcode: 199.二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @Author: liuye
 * @time: 2022/1/27$ 10:52 上午$
 */
public class RightSideView199 {

    List<Integer> list = new ArrayList<>();
    /**
     * DFS： 深度优先遍历
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return list;
        }
        int depth = 0;
        dfs(root, depth);
        return list;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if ( depth == list.size()) {
            list.add(node.val);
        }
        depth++;
        //从最右侧添加，根据递归逻辑可知，只添加一个，即最右侧
        // 如果左右子树同时有节点，优先获取右子树，右子树满足时，同一层级左子树就不满足 depth == list.size() 条件了
        dfs(node.right, depth);
        dfs(node.left, depth);
    }


    /**
     * BFS. 广度优先
     * 一般需要借助外部数据结构: 比如队列，来临时缓存遍历的数据
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                //出队，队首开始出队
                TreeNode node = deque.poll();
                //左节点先入队，从队尾进
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                //最后一个节点，即为最右侧节点
                if (i == size - 1) {
                    list.add(node.val);
                }
            }
        }
        return list;
    }
}
