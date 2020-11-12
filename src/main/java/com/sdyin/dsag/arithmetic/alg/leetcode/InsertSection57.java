package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;

/**
 * @Description 57. 插入区间
 * //给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * //
 * // 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * //输出：[[1,5],[6,9]]
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * //输出：[[1,2],[3,10],[12,16]]
 * //解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * //
 * //
 * //
 * //
 * // 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 * // Related Topics 排序 数组
 * // 👍 273 👎 0
 * @Author liuye
 * @Date 2020/11/4 15:00
 **/
public class InsertSection57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        //新区间
        int[][] res = new int[intervals.length + 1][2];

        int idx = 0;
        int i = 0;
        //找到newInterval 起始区间
        while(idx < intervals.length && intervals[i][1] < newInterval[0]){
            //idx,i 自增，填充res
            res[idx++] = intervals[i++];
        }

        //匹配newInterval 结尾区间
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            //新区间最小值
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            //新区间最大值
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            ++i;
        }

        //不用 ++idx,因为idx 比 res下标大1, 如果使用 ++idx，会多一个空区间
        res[idx++] = newInterval;

        //将剩余区间补充到结果集
        while(i < intervals.length){
            res[idx++] = intervals[i++];
        }

        //去除res 右侧多余区间
        return Arrays.copyOf(res, idx);
    }
}
