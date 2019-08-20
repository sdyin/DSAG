package com.sdyin.dsag.arithmetic.ds;

import java.util.Stack;

/**
 * 单链表实现回文判断
 * 快慢指针实现
 * @Description
 * @Author liuye
 * @Date 2019/8/20 11:23
 */
public class Palindrome {

    private class Node{

        private int data;
        private Node next;

        Node(int data){
            this.data = data;
        }
    }

    //传入首节点判断
    public static boolean isPalindrome(Node head){
        //head 为空,或者只有一个节点时
        if(head == null || head.next == null){
            return true;
        }
        if(head.next.next == null){
            if(!(head.data + "").equals(head.next.data + "")){
                return false;
            }else{
                return true;
            }
        }

        Node fastNode = head;
        Node slowNode = head;
        while(fastNode.next != null && fastNode.next.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        Stack<Node> stacks = new Stack<>();
        while(slowNode.next != null){
            stacks.push(slowNode);
            slowNode = slowNode.next;
        }

        while(!stacks.isEmpty()){
            if(!(head.data + "").equals(stacks.pop().data + "")){
                return false;
            }
            head = head.next;
        }
        return true;
    }


}
