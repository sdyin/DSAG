package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Description: 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @Author: liuye
 * @time: 2023/9/14$ 11:42 上午$
 */
public class FindKthLargest_215 {

    /**
     * 优先队列求解方式: 复杂度 0(NlogN)
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        // 默认小顶堆，根节点元素就是最小值
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        final int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}
