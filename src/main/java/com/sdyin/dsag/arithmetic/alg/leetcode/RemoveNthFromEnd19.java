package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 19.删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @Author: liuye
 * @time: 2022/4/5$ 4:27 下午$
 */
public class RemoveNthFromEnd19 {

    /**
     * 此种解法就是借用了节点
     *
     * @param head
     * @param n
     * @return
     */
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
        // 如果我们要删除倒数第N个节点，那么我们应该找到倒数第N-1个节点，然后移除其后一节点。
        while (head.next != null) {
            h1 = h1.next;
            head = head.next;
        }
        h1.next = h1.next.next;
        return h2;
    }

    /**
     * 第二种解法
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 length - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 length - k 个节点, 也就是倒数第k个节点
        return p2;
    }
}
