package com.sdyin.dsag.arithmetic.ds.binary;

import lombok.Data;

/**
 * @Description
 * @Author liuye
 * @Date 2020/9/28 12:46
 **/
@Data
public class TestNode {

    private int val;

    private TestNode next;

    public TestNode(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        TestNode node1 = new TestNode(5);
        TestNode node2 = node1;

        TestNode node11 = new TestNode(10);
        node2.next = node11;
        /**
         * node1:Node1(val=5, next=Node1(val=10, next=null))
         * node2:Node1(val=5, next=Node1(val=10, next=null))
         * 结果说明node2 改变 node1也会变，说明node2 和 node1 是一个引用地址
         */
        System.out.println("node1:" + node1.toString());
        System.out.println("node2:" + node2.toString());
    }
}
