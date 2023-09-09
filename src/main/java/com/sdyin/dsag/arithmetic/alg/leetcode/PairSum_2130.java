package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.LinkedList;

/**
 * @Description: 2130. 链表最大孪生和
 * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
 * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
 * 孪生和 定义为一个节点和它孪生节点两者值之和。
 * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
 * @Author: liuye
 * @time: 2023/9/9$ 1:26 下午$
 */
public class PairSum_2130 {

    /**
     * 借助双向链表外部结构方式
     * @param head
     * @return
     */
    public int pairSum(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            // 默认尾部插入
            list.add(head.val);
            head = head.next;
        }
        int max = Integer.MIN_VALUE;
        //取出头尾两个节点(孪生节点)比较
        while (list.size() > 0) {
            Integer firstValue = list.pollFirst();
            Integer lastValue = list.pollLast();
            max = Math.max(max, firstValue + lastValue);
        }
        return max;
    }

    /**
     * 快慢指针反转链表方式，带补充逻辑
     *
     * @param head
     * @return
     */
    public int pairSum2(ListNode head) {

        return 0;
    }
}
