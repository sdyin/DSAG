package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;

/**
 * @Description: leetcode 435. 无重叠区间
 * <p>
 *     给定一个区间的集合，找到需要移除区间的最小数量，使得剩余区间互不重叠
 *     注意:
 *     可以认为区间的终点总是大于它的起点。
 *     区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *     示例 1:
 *     输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *     输出: 1
 *     解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *     示例 2:
 *     输入: [ [1,2], [1,2], [1,2] ]
 *     输出: 2
 *     解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *     示例 3:
 *     输入: [ [1,2], [2,3] ]
 *     输出: 0
 *     解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * @Author: liuye
 * @time: 2023/11/22$ 1:41 下午$
 */
public class EraseOverlapIntervals_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //按照结束区间排序，即按照尾节点大小排序
        Arrays.sort(intervals, (a1, a2) -> a1[1] - a2[1]);

        //第一个区间结束值
        int end = intervals[0][1];
        int count = 0;
        //后面区间如果起始值小于end，则算重叠，需要累加
        //如果大于等于，则重新获取end值，循环直到最后
        for (int i = 1; i < intervals.length; i++) {
            int[] arr = intervals[i];
            if(arr[0] < end){
                count++;
            }else{
                end = arr[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // int[][] arr = {{1,2},{2,3},{3,4},{1,3}};
        int[][] arr = {{1,2},{1,3},{3,4},{2,3}};
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        System.out.println(arr);
    }
}
