package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.PriorityQueue;

/**
 * @Description: 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 这一题与合并两个升序链表类似，困难在于k个链表是动态的,我们需要动态判断k个链表的头结点哪个更大，以及后续移动对应的节点。
 * 如果是自己写那块逻辑，会相对繁琐一些，但是如果我们使用优先队列数据结构类型，那么就会很简单。
 *
 * @Author: liuye
 * @time: 2022/4/5$ 3:51 下午$
 */
public class MergeKLists23 {

    /**
     * 优先队列解法
     * 时间复杂度：O(kn*logk)
     * 空间复杂度：O(k)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        //还是有虚拟头结点
        ListNode p = new ListNode(-1);
        ListNode dummy = p;

        //指定最小堆(优先队列)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode l1, ListNode l2) -> l1.val - l2.val);
        for (ListNode node: lists) {
            //添加null 元素时会抛出空指针异常
            if (node != null) {
                pq.add(node);
            }
        }

        while (!pq.isEmpty()) {
            // 获取最小值对应的链表
            ListNode node = pq.poll();
            p.next = node;
            // 如果链表还有元素，重新加入优先队列
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * 分治解法
     * 时间复杂度：O(n*logk)
     * 空间复杂度：O(logk), 递归调用栈
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null && lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1!= null && l2!= null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1!= null) {
            p.next = l1;
        }
        if (l2!= null) {
            p.next = l2;
        }
        return dummy.next;
    }
}
