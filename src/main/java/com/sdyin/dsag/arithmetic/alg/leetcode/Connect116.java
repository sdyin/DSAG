package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.LinkedList;

/**
 * @Description: 116. 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 * @Author: liuye
 * @time: 2022/5/30$ 9:15 下午$
 */
public class Connect116 {

    //bfs 解法
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);

        while (list.size() > 0) {
            //建立next关系
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }

            int size = list.size();
            while (size > 0) {
                Node node = list.pop();
                if (node.left != null) {
                    list.addLast(node.left);
                }
                if (node.right != null) {
                    list.addLast(node.right);
                }
                size--;
            }
        }
        return root;
    }

    /**
     * 递归方式解法
     *
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        fillNext(root.left, root.right);
        return root;
    }

    private void fillNext(Node node1, Node node2) {
        if(node1 == null || node2 == null){
            return;
        }
        //处理逻辑: 补充节点next关系
        node1.next = node2;

        fillNext(node1.left, node1.right);
        fillNext(node2.left, node2.right);
        //两个节点之间也要增加
        fillNext(node1.right, node2.left);

    }



}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
