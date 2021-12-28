package com.sdyin.dsag.arithmetic.ds.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: 合并k个升序链表
 * @Author: liuye
 * @time: 2021/12/27$ 6:37 下午$
 */
public class MergeManyLinkedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        //添加进优先队列
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null){
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            //尾节点指向下一节点
            tail.next = new ListNode(node.val);
            //尾结点调整到下一节点
            tail = tail.next;
            //如果ListNode后还有节点，添加到优先队列
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(66);
        pq.add(55);
        pq.add(88);
        pq.add(77);

        while (!pq.isEmpty()) {
            final Integer poll = pq.poll();
            System.out.println("result:" + poll);
        }

    }
}


