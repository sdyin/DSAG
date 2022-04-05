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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        //还是有虚拟头结点
        ListNode p = new ListNode(-1);
        ListNode dummy = p;

        //指定最小堆
        final PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode l1, ListNode l2) -> l1.val - l2.val);
        for (ListNode node: lists) {
            //添加null 元素时会抛出空指针异常
            if (node != null) {
                pq.add(node);
            }
        }

        while (!pq.isEmpty()) {
            final ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
