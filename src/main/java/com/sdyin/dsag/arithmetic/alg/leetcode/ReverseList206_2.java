package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description:
 * @Author: liuye
 * @time: 2023/7/18$ 5:03 下午$
 */
public class ReverseList206_2 {

    // 迭代方式
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while(head != null){
            ListNode next = head.next;
            head.next = dummy.next;
            // 虚拟节点前移
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }

    // 递归方式
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList2(head.next);
        // 后序处理, 调整为环形链表
        head.next.next = head;
        head.next = null;
        return node;
    }


}
