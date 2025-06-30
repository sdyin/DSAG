package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * leetcode. 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 *
 * @Author: liuye
 * @time: 2025/6/30$ 11:55$
 */
public class Merge56 {

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();
        if (intervals.length == 1) {
            return intervals;
        }

        // 按区间起始位置排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] start = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (start[1] < intervals[i][0]) {
                result.add(Arrays.asList(start[0], start[1]));
                start = intervals[i];
            } else {
                start[1] = Math.max(start[1], intervals[i][1]);
            }
        }
        result.add(Arrays.asList(start[0], start[1]));

        // result集合转为数组
        int[][] resultArray = result.stream()
                .map(sublist -> sublist.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
        return resultArray;
    }
}
