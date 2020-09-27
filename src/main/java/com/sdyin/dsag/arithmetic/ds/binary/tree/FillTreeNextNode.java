package com.sdyin.dsag.arithmetic.ds.binary.tree;

/**
 * @Description 116. 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 * 本题解题思路主要是 两个节点不为一个父节点时,也需要next，那么一个node无法完成，可以通过传参两个node节点来完成这种关系
 * @Author liuye
 * @Date 2020/9/27 16:10
 **/
public class FillTreeNextNode {
    public Node connect(Node root) {
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

        //处理逻辑
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
};
