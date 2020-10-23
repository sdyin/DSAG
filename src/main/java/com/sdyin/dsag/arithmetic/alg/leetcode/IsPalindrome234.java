package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * @Author liuye
 * @Date 2020/10/23 10:36
 **/
public class IsPalindrome234 {

    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        final int size = list.size();
        int pre = 0;
        int last = list.size() - 1;
        while (last > pre) {
            if (!list.get(pre).equals(list.get(last))) {
                return false;
            }
            pre++;
            last--;
        }
        return true;
    }
}
