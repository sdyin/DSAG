package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 2095. 删除链表的中间节点
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
 * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
 *
 * @Author: liuye
 * @time: 2023/9/9$ 9:57 上午$
 */
public class DeleteMiddle_2095 {

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return head.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        /**
         * 为什么这里fast 初始值是head，而slow 初始值是dummy？不能slow 初始值是head, fast 初始值是head.next吗？
         * 让 slow 初始值是 head，fast 初始值是 head.next。这种方式也是可以的，但是它会使得 fast 指针在链表长度为偶数时停在最后一个节点，而 slow 指针停在中间两个节点的前一个。这样，你需要额外的判断来处理删除中间节点。
         * 而如果 fast 初始值是 head，slow 初始值是 dummy，则 fast 指针在链表长度为偶数时会停在 null，slow 指针会停在中间两个节点的前一个。这样，你可以直接通过 slow.next = slow.next.next; 来删除中间节点，无需额外的判断。
         * 所以，这两种方式都是可以的，但是后者在代码实现上更简洁一些。
         */
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
