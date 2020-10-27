package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description 203.移除元素
 * //删除链表中等于给定值 val 的所有节点。
 * //
 * // 示例:
 * //
 * // 输入: 1->2->6->3->4->5->6, val = 6
 * //输出: 1->2->3->4->5
 * //
 * // Related Topics 链表
 * // 👍 467 👎 0
 * @Author liuye
 * @Date 2020/10/23 17:48
 **/
public class RemoveElements203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        ListNode cur = head;

        while(cur != null){
            //不是要删除的值时,拼接该值为下一节点
            if(cur.val != val){
                pre.next = cur;
                //pre 直像尾节点
                pre = pre.next;
            }
            cur = cur.next;
        }
        pre.next = null;
        return dummy.next;

    }
}
