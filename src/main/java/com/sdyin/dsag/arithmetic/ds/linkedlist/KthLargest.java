package com.sdyin.dsag.arithmetic.ds.linkedlist;

import java.util.PriorityQueue;

/**
 * @Description: 返回数据流中第k大的元素
 * @Author: liuye
 * @time: 2021/12/28$ 4:32 下午$
 */
public class KthLargest {

    public int KthLargest(int k, int[] nums) {
        //降序排序，大顶堆,队首即第k大元素
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.offer(nums[i]);
            } else {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}
