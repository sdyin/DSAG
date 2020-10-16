package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description 82.删除重复链表
 * //给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * //
 * // 示例 1:
 * //
 * // 输入: 1->2->3->3->4->4->5
 * //输出: 1->2->5
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: 1->1->1->2->3
 * //输出: 2->3
 * // Related Topics 链表
 * // 👍 384 👎 0
 * @Author liuye
 * @Date 2020/10/16 15:06
 **/
public class DeleteDuplicatesLinked83 {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){

            if(fast.val != slow.val){
                //获取slow下一节点
                slow.next = fast;
                //slow 移位到下一节点
                slow = slow.next;
            }
            //fast向后移位 要放if语句下面
            //不然上述slow.next = fast 节点指代的就不正确
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
