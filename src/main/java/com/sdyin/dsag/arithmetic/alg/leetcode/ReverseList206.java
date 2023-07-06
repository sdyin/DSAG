package com.sdyin.dsag.arithmetic.alg.leetcode;

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
        //初始pre节点为null
        ListNode pre = null;

        ListNode cur = head;

        while (cur != null) {
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

    /**
     * 比较容易想到 但是不够优雅
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        while (p.next != null) {
            //暂存next节点
            ListNode next = p.next;
            ListNode node = new ListNode(next.val);
            p.next = null;
            //这里不能 node.next = p; 因为后续p会变化
            node.next = dummy.next;
            dummy.next = node;
            p = next;
        }
        return dummy.next;
    }

    /**
     * reverseList2方法 优化简洁版本
     *
     * @param head
     * @return
     */
    public ListNode reverseList2_1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = dummy.next;
            dummy.next = node;
            head = head.next;
        }
        return dummy.next;
    }

    /**
     * 递归方式
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //递归，找到最后一个节点, 注意这里的入参是head.next
        ListNode last = reverseList3(head.next);
        //这个语句可以这样理解： 比如有A->B 节点。
        // 就是本身A指向B，现在把B也指向A，循环链表
        head.next.next = head;
        //配合上一句也就是反转了相邻两个节点指向，原本A->B, 现在变成B->A
        head.next = null;

        return last;
    }

}
