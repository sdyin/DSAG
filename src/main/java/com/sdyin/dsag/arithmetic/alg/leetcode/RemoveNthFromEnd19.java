package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 19.删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @Author: liuye
 * @time: 2022/4/5$ 4:27 下午$
 */
public class RemoveNthFromEnd19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        ListNode h1 = head;
        ListNode h2 = head;
        //先后移n位
        for (int i = 0; i < n; i++) {
            //当n大于 链表长度时场景
            if (head == null) {
                return h2;
            }
            head = head.next;
        }
        //链表长度 = n 时，去除首节点
        if (head == null) {
            return h2.next;
        }
        //这里为什么是head.next 而不是head?
        //因为如果是head，那么此时head没有后移，却导致h1后移了一位
        while (head.next != null) {
            h1 = h1.next;
            head = head.next;
        }
        h1.next = h1.next.next;
        return h2;
    }
}
