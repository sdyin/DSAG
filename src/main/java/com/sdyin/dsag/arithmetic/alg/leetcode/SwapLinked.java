package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 24.两两交换链表中的节点
 * @Author: liuye
 * @time: 2020/10/13$ 下午8:57$
 */
public class SwapLinked {

    //递归方式解题
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;

        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 迭代方式解题
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        //此处不能返回 temp.next, 因为temp已经指向后面每次迭代节点
        //TODO 此处为什么不能返回 head 节点？
        return dummyHead.next;
    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
