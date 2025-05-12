package com.sdyin.dsag.arithmetic.ds.linkedlist;

/**
 * @Description 链表
 * @Author liuye
 * @Date 2020/10/10 15:11
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
