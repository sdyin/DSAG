package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @Author: liuye
 * @time: 2023/7/2$ 10:06 下午$
 */
public class RemoveNthFromEnd_19 {

    /**
     * 思路: 倒数第N位，可以采用双指针，让一个指针先走N步，然后两个指针同时走，当先走的指针走到尾部时，后走的指针就是倒数第N位
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
}
