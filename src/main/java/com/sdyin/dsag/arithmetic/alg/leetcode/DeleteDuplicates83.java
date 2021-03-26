package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * @Author: liuye
 * @time: 2021/3/26$ 下午2:54$
 */
public class DeleteDuplicates83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null){
            if(node.val == node.next.val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return head;
    }
}
