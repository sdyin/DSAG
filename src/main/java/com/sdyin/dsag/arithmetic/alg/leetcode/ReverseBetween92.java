package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * @Author: liuye
 * @time: 2021/3/18$ 下午5:51$
 */
public class ReverseBetween92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode q = dummyHead.next;

        for (int i = 0; i < left - 1; i++) {
            g = g.next;
            q = q.next;
        }

        for (int i = 0; i < right - left; i++) {
            ListNode node = q.next;

            //去除q的后一节点,实际上就是去除node,继续下一节点的插入
            //这一步放在循环最后一行会影响g节点
            q.next = q.next.next;

            //g的后继节点指向node,更改node的后继节点
            node.next =  g.next;
            //node指向g, 配合上一步就是将node 插入g节点后
            g.next = node;


        }


        return dummyHead.next;

    }
}
