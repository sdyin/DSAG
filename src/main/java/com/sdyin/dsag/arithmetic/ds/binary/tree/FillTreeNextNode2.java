package com.sdyin.dsag.arithmetic.ds.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 117.填充每个节点的下一个右侧节点指针
 * 此题与116对应，只是该题中二叉树不是完全二叉树
 * 解法思路： 此题因为不是完全二叉树，用BFS层级遍历写法会更容易
 * @Author liuye
 * @Date 2020/9/28 9:59
 **/
public class FillTreeNextNode2 {

    /**
     * BFS做法，利用队列存储每个层级的节点
     * @param root
     * @return
     */
    public Node connect(Node root) {

        if(root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            Node pre = null;
            //每层节点数量
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                //不为空，则指向栈中下一节点
                if(pre != null){
                    pre.next = node;
                }

                pre = node;

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 直接用当前Node节点
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if(root == null){
            return root;
        }
        Node cur = root;

        while(cur != null){

            //虚拟节点，当做前节点
            Node dummy = new Node(0);
            Node pre = dummy;

            while (cur != null) {
                //下一层级子节点赋值next
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right != null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //当前层下一节点
                cur = cur.next;
            }
            //下一层级
            cur=dummy.next;
        }

        return root;
    }

}
