package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description:
 * @Author: liuye
 * @time: 2023/7/2$ 7:28 下午$
 */
public class PartitionListNode86 {

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        while (head != null) {
            int curValue = head.val;
            ListNode curNode = new ListNode(curValue);
            if (curValue < x) {
                p1.next = curNode;
                p1 = p1.next;
            } else {
                p2.next = curNode;
                p2 = p2.next;
            }
            head = head.next;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
