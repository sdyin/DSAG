package com.sdyin.dsag.arithmetic.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 环形链表
 * @Author: liuye
 * @time: 2021/4/26$ 上午11:30$
 */
public class CircleLinkedList {

    /**
     * 去重容器方式
     * 解法: 放入去重容器中，插入失败即是有重复节点，就说明是环形链表。
     * 如果执行结束都没有,那肯定非环形链表了。
     * <p>
     * 特点注意： 这里set容器存储类型不能是节点的值int类型，因为链表节点值相等并不能说明是一个节点。
     * 要直接存储节点node对象
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            //有相同节点
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    /**
     * 双指针-》 快慢指针方式
     *  设置两个节点: 快慢节点, 快节点每次移动两格，慢节点每次移动一格。
     *  如果能相遇，说明是环形，否则即不是
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        //如果是环形链表，则要依赖fast == slow 时才能停止循环
        while (fast != null && fast.next != null) {
            if(fast == slow){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
