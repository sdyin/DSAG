package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @Author: liuye
 * @time: 2022/5/1$ 7:03 下午$
 */
public class SwapPairs24 {

    /**
     * 两两交换链表中的节点-调整指针方式
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode g = dummy;

        ListNode p = head;
        while (p != null && p.next != null) {
            //暂存next节点
            ListNode node = p.next;

            //反转 p和 p.next
            p.next = p.next.next;
            node.next = g.next;
            g.next = node;

            //调整dummy位置
            g = p;
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * 两两交换链表中的节点-递归方式
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        // 递归
        head.next = swapPairs2(newHead.next);
        return newHead;
    }
}
