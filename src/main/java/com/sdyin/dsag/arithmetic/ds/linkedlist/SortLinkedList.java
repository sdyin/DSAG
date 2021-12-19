package com.sdyin.dsag.arithmetic.ds.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @Author: liuye
 * @time: 2021/4/27$ 上午9:19$
 */
public class SortLinkedList {

    /**
     * 容器方式-有点蠢
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list = list.stream().sorted().collect(Collectors.toList());
        ListNode root = new ListNode(list.get(0));
        ListNode cur = root;
        for (int i = 1; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            cur.next = node;
            cur = node;
        }
        return root;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(9);
        list.add(4);
        list.add(4);
        list.add(1);
        list = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list);
    }
}
