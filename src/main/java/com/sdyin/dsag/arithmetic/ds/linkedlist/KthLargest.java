package com.sdyin.dsag.arithmetic.ds.linkedlist;

import java.util.PriorityQueue;

/**
 * @Description: 返回数据流中第k大的元素
 * @Author: liuye
 * @time: 2021/12/28$ 4:32 下午$
 */
public class KthLargest {

    public int KthLargest(int k, int[] nums) {
        //小顶堆,假设元素为k个，队首即第k大元素
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < nums.length; i++) {
            //i 从0开始，故这里是 i<k
            if (i < k) {
                pq.offer(nums[i]);
            } else {
                //注意这里是先添加进去，再移除
                pq.offer(nums[i]);
                pq.poll();

            }
        }
        return pq.peek();
    }
}
