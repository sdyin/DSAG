package com.sdyin.dsag.arithmetic.ds.linkedlist;

/**
 * @Description:
 * @Author: liuye
 * @time: 2025/3/17$ 17:01$
 */
public class RevertList {

    public ListNode revert(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        ListNode next = null, prev = null;

        while (curr.next != null) {
            // 暂存下一节点
            next = curr.next;

            //处理当前节点
            curr.next = prev;
            prev = curr;

            curr =  next;
        }
        curr.next = prev;

        return curr;
    }
}
