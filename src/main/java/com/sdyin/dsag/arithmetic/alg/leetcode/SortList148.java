package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * @Author: liuye
 * @time: 2022/5/1$ 9:56 上午$
 */
public class SortList148 {

    /**
     * 归并排序方式
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if ( head == null || head.next == null) {
            return head;
        }

        //快慢指针
        ListNode fast = head.next, slow = head;
        //快指针每次移动两步，慢指针一步
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }


        ListNode tmp = slow.next;
        //断开链表
        slow.next = null;

        //递归处理左右两部分链表
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        return merge(left, right);
    }

    //合并两个有序链表
    private ListNode merge(ListNode left, ListNode right) {
        //虚拟节点
        ListNode dummy = new ListNode(),tail = dummy;
        //合并两个链表
        while( left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                tail = tail.next;
                left = left.next;
            } else {
                tail.next = right;
                tail = tail.next;
                right = right.next;
            }

            if (left != null) {
                tail.next = left;
            }
            if (right != null) {
                tail.next = right;
            }
        }
        return dummy.next;
    }

    /**
     * 借助外部结构, 非直接操作指针方式
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if ( head == null || head.next == null) {
            return head;
        }

        List<Integer> list = new ArrayList<>();
        while ( head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode root = new ListNode(list.get(0));
        ListNode p = root;
        for (int i = 1; i < list.size(); i++) {
            ListNode newNode = new ListNode(list.get(i));
            p.next = newNode;
            p = newNode;
        }
        return root;
    }


}
