package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * @Author: liuye
 * @time: 2022/4/5$ 6:39 下午$
 */
public class MiddleNode876 {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
