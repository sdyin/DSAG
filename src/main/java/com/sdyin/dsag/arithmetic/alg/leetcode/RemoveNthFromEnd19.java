package com.sdyin.dsag.arithmetic.alg.leetcode;
import com.sdyin.dsag.arithmetic.ds.linkedlist.ListNode;

/**
 * @Description: leetcode 19.删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @Author: liuye
 * @time: 2022/4/5$ 4:27 下午$
 */
public class RemoveNthFromEnd19 {

    /**
     * 此种解法就是借用了节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        // 先让节点后移N个节点
        for(int i = 0; i < n; i++) {
            head = head.next;
        }

        //特殊场景，链表已遍历完，倒数第N位就是第一位，直接响应
        if (head == null) {
            return p2.next;
        }

        // 正常场景：走到尾节点，假设链表长度是K，那就继续走K-N步
        // 此时p1节点走了K-N步，也就是此时p1就是倒数第N个节点
        while(head != null) {
            head = head.next;
            if (head != null) {
                p1 = p1.next;
            } else {
                p1.next = p1.next.next;
            }
        }
        return p2;
    }

    /**
     * 第二种解法
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 length - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 length - k 个节点, 也就是倒数第k个节点
        return p2;
    }


    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        int length = 0;
        // 先遍历计算链表长度
        while (head != null) {
            length++;
            head = head.next;
        }
        // 该下标索引处 需移除后一节点
        int index = length - n;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;

        return dummy.next;
    }
}
