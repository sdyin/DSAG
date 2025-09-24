package com.sdyin.dsag.arithmetic.ds.linkedlist;

/**
 * @Description: 反转链表, leetcode-206
 * @Author: liuye
 * @time: 2021/4/25$ 上午9:08$
 */
public class RevertLinkedList {


    /**
     * 迭代方式
     * 主要就是梳理清楚链表节点的调整
     *
     * @param head
     * @return
     */
    public ListNode byIteration(ListNode head) {
        if (head == null) {
            return null;
        }
        //记录当前遍历到的节点
        ListNode curr = head;

        ListNode next, prev = null;
        while (curr.next != null) {
            //暂存下一节点
            next = curr.next;
            //断开下一节点连接，指向新的节点
            curr.next = prev;
            //记录前一节点
            prev = curr;
            //获取暂存值，继续遍历下一节点
            curr = next;
        }
        curr.next = prev;
        return curr;
    }

    /**
     * 递归方式
     * 思路一：递归到最后一个节点，然后依次向前一次递归交换,这样最后响应的是反转后的尾结点，
     * 所以定义了一个局部变量，保存头节点，最后递归处理完毕后返回头结点
     *
     * @param head
     * @return
     */
    public ListNode byRecursion(ListNode head) {
        if (head == null) {
            return null;
        }
        recursion(head);
        return root;
    }

    public ListNode root;

    public ListNode recursion(ListNode head) {
        ListNode next = head.next;

        //下一个节点为尾结点时 作为头结点响应
        if (next == null) {
            ListNode node = new ListNode(head.val);
            root = node;
            return node;
        }
        //递归处理
        ListNode node = recursion(next);
        //清空当前节点的尾结点，防止链表成环
        head.next = null;
        //调换当前节点和 后置节点的指针关系
        node.next = head;

        return head;
    }

    /**
     * 递归
     * 思路二: 从头节点的下一节点开始，每遍历到一个非空节点 就把该节点提至最前
     *
     * @param head
     * @return
     */
    public ListNode byRecursion2(ListNode head) {
        root = head;
        recursion2(head);
        return root;
    }

    public ListNode recursion2(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        //head的next节点
        ListNode next = head.next;
        //head 直接指向next的next节点，断开next节点
        head.next = head.next.next;
        //next节点放到首位
        next.next = root;

        root = next;
        //递归调用，递归代码如果放在逻辑处理后，就是每递归一个节点处理一个节点，从前往后
        // 如果放在逻辑处理前，就是递归到最后然后开始处理，从后往前
        recursion2(head);
        return next;
    }

    /**
     * 更简洁的递归方式
     *
     * @param head
     * @return
     */
    public ListNode byRecursion3(ListNode head) {
        // 为空或者只有一个节点时，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 递归调用，传入下一个节点，目的是为了到达最后一个节点
        ListNode newHead = byRecursion3(head.next);

        // 将当前节点的下一个节点的 next 指针指向当前节点,
        // 反转当前节点和下一节点的指针
        head.next.next = head;
        // 断开当前节点的 next 指针，防止链表成环
        head.next = null;
        return newHead;
    }





    public static void main(String[] args) {
        RevertLinkedList list = new RevertLinkedList();

        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node = list.byRecursion2(node1);
        System.out.println(node);
    }


}
