package com.sdyin.dsag.arithmetic.alg.leetcode;

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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        // 进位flag
        boolean carryFlag = false;
        ListNode resultNode = new ListNode(-1);
        ListNode lastNode = new ListNode(-2);
        resultNode.next = lastNode;
        while(l1 != null || l2 != null || carryFlag){
            int value1 = 0;
            int value2 = 0;
            if (l1 != null) {
                value1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value2 = l2.val;
                l2 = l2.next;
            }
            int data = value1 + value2;
            if (carryFlag) {
                data++;
            }
            carryFlag = data >= 10 ? true : false;
            int value = data % 10;
            ListNode node = new ListNode(value);
            lastNode.next = node;
            lastNode = node;
        }
        return resultNode.next.next;
    }

}
