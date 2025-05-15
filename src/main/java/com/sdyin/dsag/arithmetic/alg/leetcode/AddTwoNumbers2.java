package com.sdyin.dsag.arithmetic.alg.leetcode;
import com.sdyin.dsag.arithmetic.ds.linkedlist.ListNode;

/**
 * @Description: leetcode: 2.两数相加
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * @Author: liuye
 * @time: 2022/1/24$ 11:36 上午$
 */
public class AddTwoNumbers2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;

        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(6);
        a1.next = a2;
        ListNode a3 = new ListNode(4);
        a2.next = a3;

        final ListNode listNode = addTwoNumbers(l1, a1);
        System.out.println(listNode);
    }

    /**
     * 可以实现，就是代码略微丑
     *
     * @param l1
     * @param l2
     * @return
     */
    public com.sdyin.dsag.arithmetic.ds.linkedlist.ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        // 标识后一次是否进位：0.不进位，1.进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                int sum = l2.val + carry;
                if (sum > 9) {
                    cur.next = new ListNode(sum % 10);
                    carry = 1;
                } else {
                    cur.next = new ListNode(sum);
                    carry = 0;
                }
                cur = cur.next;
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                int sum = l1.val + carry;
                if (sum > 9) {
                    cur.next = new ListNode(sum % 10);
                    carry = 1;
                } else {
                    cur.next = new ListNode(sum);
                    carry = 0;
                }
                cur = cur.next;
                l1 = l1.next;
                continue;
            }

            int v1 = l1.val;
            int v2 = l2.val;
            int sum = v1 + v2 + carry;
            if (sum > 9) {
                cur.next = new ListNode(sum % 10);
                carry = 1;
            } else {
                cur.next = new ListNode(sum);
                carry = 0;
            }
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 如果还有进位，需要额外处理
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return res.next;
    }

    /**
     * 优化版本
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // 标识后一次是否进位：0.不进位，1.进位
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        return dummy.next;
    }

}
