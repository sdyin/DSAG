package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 21.合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Author: liuye
 * @time: 2022/4/5$ 3:14 下午$
 */
public class mergeTwoLists21 {

    /**
     * 合并两个有序链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = new ListNode(-1);
        ListNode dummy = p;
        while (list1 != null && list2 != null) {
            ListNode newNode = null;
            if (list1.val <= list2.val) {
                newNode = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                newNode = new ListNode(list2.val);
                list2 = list2.next;
            }
            p.next = newNode;
            p = p.next;
        }

        if (list1 != null) {
            p.next = list1;
        }

        if (list2 != null) {
            p.next = list2;
        }
        return dummy.next;
    }
}
