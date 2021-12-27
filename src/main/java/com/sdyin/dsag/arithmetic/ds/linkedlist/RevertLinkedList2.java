package com.sdyin.dsag.arithmetic.ds.linkedlist;

/**
 * @Description: 反转单链表
 * @Author: liuye
 * @time: 2021/12/27$ 2:06 下午$
 */
public class RevertLinkedList2 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        ListNode listNode2 = new ListNode(4);
        listNode.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(2);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(1);
        listNode4.next = listNode5;
        ListNode node = revertRecursion(listNode);
    }


    /**
     * 迭代方式，此方式时间复杂度为O(n), 空间复杂度稍高,为O(n) 不是0(1)
     *
     * @param head
     * @return
     */
    private static ListNode revert(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode resultNode = new ListNode(head.val);
        while (head.next != null) {
            //获取下一节点
            ListNode next = head.next;
            //新的独立节点
            ListNode newNextNode = new ListNode(next.val);
            //新节点放置队首
            newNextNode.next = resultNode;

            resultNode = newNextNode;
            //迭代下一节点
            head = next;
        }
        return resultNode;
    }

    private static ListNode root;

    /**
     * 递归方式-反转单链表
     *
     * @param head
     * @return
     */
    private static ListNode revertRecursion(ListNode head) {
        root = head;
        recursion(head);
        return root;
    }

    private static ListNode recursion(ListNode head) {
        //判断当前节点和下一节点
        if (head == null || head.next == null) {
            return head;
        }

        final ListNode next = head.next;

        head.next = head.next.next;

        next.next = root;

        root = next;
        //递归处理head节点
        recursion(head);

        return next;
    }
}
