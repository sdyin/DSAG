package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * @Description 143.重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * @Author liuye
 * @Date 2020/10/20 10:17
 **/
public class ReorderList143 {

    /**
     * 存储 + 双指针
     *
     * @param head
     */
    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }
        //存到 list 中去
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        //头尾指针依次取元素
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            //偶数个节点的情况，会提前相遇,相遇即结束
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        //最后节点下一节点置为空
        list.get(i).next = null;
    }
}
