package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 328. 奇偶链表
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 *
 * 示例一:
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 *
 * 示例二:
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 *
 * 提示:
 * n ==  链表中的节点数
 * 0 <= n <= 104
 * -106 <= Node.val <= 106
 *
 * @Author: liuye
 * @time: 2023/9/9$ 11:19 上午$
 */
public class OddEvenList_328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 奇数节点指针
        ListNode odd = head;
        // 偶数节点指针
        ListNode even = head.next;
        // 偶数节点头结点
        ListNode evenHead = even;

        // 分别组装奇数节点，偶数节点
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        // 连接奇偶节点
        odd.next = evenHead;
        return head;
    }
}
