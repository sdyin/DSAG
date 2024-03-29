package com.sdyin.dsag.arithmetic.ds.linkedlist;

/**
 * @Description 环形链表2
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * @Author liuye
 * @Date 2020/10/10 15:10
 **/
public class CircleLinked2 {

    public ListNode detectCycle(ListNode head) {

        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(true){
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }

        //第一次相遇后，快指针复原为头节点，快慢指针均只走一步,相等时即为环形链表起点
        //当第一次相遇后，假设头节点到环形链表起点距离为a, 慢指针再走a步,肯定到达环形链表起点
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
