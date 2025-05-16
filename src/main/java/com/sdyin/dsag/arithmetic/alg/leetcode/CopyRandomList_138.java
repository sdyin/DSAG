package com.sdyin.dsag.arithmetic.alg.leetcode;

import com.sdyin.dsag.arithmetic.ds.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: leetcode 138. 复制带随机指针的链表
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。
 * 那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 *
 * 返回复制链表的头节点。
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 * 提示：
 *
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random 为 null 或指向链表中的节点。    
 *  
 * 
 * @Author: liuye
 * @time: 2025/5/16$ 14:46$
 */
public class CopyRandomList_138 {

    /**
     * 直观简单: 借助hashMap 解法, 时间复杂度O(n), 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 第一次遍历, 新建所有新节点，并建立map 映射关系
        // key 为 原节点， value 为 新节点
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 第二次遍历
        cur = head;
        while (cur!= null) {
            // 新节点的next 指向 原节点next 对应的新节点
            map.get(cur).next = map.get(cur.next);
            // 新节点的random 指向 原节点random 对应的新节点
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }


    /**
     * 原地解法: 时间复杂度O(n), 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return head;
        }
        // 原节点后面都插入一个新节点
        Node cur = head;
        while (cur!= null) {
            // 插入新节点
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;

            cur = cur.next.next;
        }


        // 构建每个新节点的random指向
        cur = head;
        while (cur!= null) {
            // 新节点的random 指向 原节点random 对应的新节点
            // cur.random 指代的是原节点的random
            // cur.random.next 指代的是原节点random对应的新节点
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 拆分两个链表
        cur = head;
        Node newHead = head.next;
        while (cur != null) {
            Node newNode = cur.next;
            // 因为原节点后面肯定有新节点， 所以这里cur.next.next不用判空
            cur.next = cur.next.next;

            // 注意新节点这里就需要判断了, 防止空指针异常
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
            }
            cur = cur.next;
        }
        return newHead;
    }
}
