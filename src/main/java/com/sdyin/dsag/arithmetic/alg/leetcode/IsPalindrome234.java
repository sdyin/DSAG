package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * @Author liuye
 * @Date 2020/10/23 10:36
 **/
public class IsPalindrome234 {

    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        final int size = list.size();
        int pre = 0;
        int last = list.size() - 1;
        while (last > pre) {
            if (!list.get(pre).equals(list.get(last))) {
                return false;
            }
            pre++;
            last--;
        }
        return true;
    }

    ListNode left;

    /**
     * 链表后序遍历方式
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        left = head;
        return revert(head);
    }

    private boolean revert(ListNode right) {
        if (right == null) {
            return true;
        }

        boolean boo = revert(right.next);
        //后序遍历处理(子处理是true 并且当前位置left.val == right.val)
        boo = boo && (left.val == right.val);

        left = left.next;
        return boo;
    }

    /**
     * 快慢指针方式
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // 快慢指针找到中点并且反转前半部分链表
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // 处理奇数长度情况
        if (fast!= null) {
            slow = slow.next;
        }

        // 比较前半部分和后半部分
        while (prev!= null && slow!= null) {
            if (prev.val!= slow.val) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }


}
