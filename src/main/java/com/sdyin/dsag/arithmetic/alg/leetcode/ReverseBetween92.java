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

    /**
     * 迭代解法
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode q = dummyHead.next;

        // 为什么这里是 < 不是 <=: 因为left 是从1开始的
        // 为什么这里是left - 1: 因为循环是从(q节点)首节点开始，不是从首节点的前驱节点。
        // (我们要反转区间链表，就要找到目标链表的第一个元素以及前驱元素)
        for (int i = 0; i < left - 1; i++) {
            g = g.next;
            q = q.next;
        }

        for (int i = 0; i < right - left; i++) {
            // 暂存后一节点
            ListNode node = q.next;

            //去除q的后驱节点,实际上就是链表去除node节点
            //这一步放在循环最后一行会影响g节点
            q.next = q.next.next;

            //就是把node节点(也就是原q的后驱节点)，插入到q链表的队头
            node.next =  g.next;
            //g节点变更为调整后的链表队头
            g.next = node;

        }

        return dummyHead.next;
    }
}
