package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null。
 * @Author: liuye
 * @time: 2022/4/5$ 7:47 下午$
 */
public class GetIntersectionNode160 {

    /**
     * 如果链表相交，那么链表的后一部分肯定相同。
     * 但是链表长度可能不一样，所以不一定同时到达相交节点
     * 这时候有一个小技巧: 两个链表尾部分别拼接上另一链表.这样就能达到两个链表长度相同，如果有相交链表,同时达到相交链表。
     * (如果没有相交链表，则p1 和 p2 同时为null)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            if (p1 != null) {
                p1 = p1.next;
            } else {
                p1 = headB;
            }

            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = headA;
            }
        }
        return p1;
    }
}
