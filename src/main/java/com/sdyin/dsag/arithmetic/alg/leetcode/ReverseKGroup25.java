package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * @Author: liuye
 * @time: 2022/5/2$ 8:39 下午$
 */
public class ReverseKGroup25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if ( head == null) {
            return head;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b != null) {
                b = b.next;
            } else {
                //链表元素不足k个,无需反转
                return head;
            }
        }
        //反转前k个元素，返回新链表头节点
        ListNode newHead = revert(a, b);

        //递归，再从b开始，翻转k个元素
        //并且连接链表
        a.next =  reverseKGroup(b, k);
        //返回反转后链表的头节点
        return newHead;
    }

    /**
     * 反转链表中 [a, b) 左闭右开
     *
     * @param a
     * @param b
     * @return
     */
    public ListNode revert(ListNode a, ListNode b) {
        // 反转链表模板代码
        ListNode pre = null;
        ListNode cur = a;
        // 注意这里结束条件是到b节点
        while(cur != b) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
