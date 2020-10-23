package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.List;

/**
 * @Description 206.反转链表
 * //反转一个单链表。
 * //
 * // 示例:
 * //
 * // 输入: 1->2->3->4->5->NULL
 * //输出: 5->4->3->2->1->NULL
 * //
 * // 进阶:
 * //你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * // Related Topics 链表
 * // 👍 1293 👎 0
 * @Author liuye
 * @Date 2020/10/22 18:02
 **/
public class ReverseList206 {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;

        ListNode cur = head;

        while(cur != null){
            //暂存下一节点
            ListNode nextNode = cur.next;

            //逆序
            cur.next = pre;

            //替换全局节点(已逆序处理节点)
            pre = cur;

            cur = nextNode;
        }

        return pre;
    }

}
