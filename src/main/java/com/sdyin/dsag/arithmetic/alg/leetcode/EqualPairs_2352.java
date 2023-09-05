package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 2352. 相等行列对
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * @Author: liuye
 * @time: 2023/9/5$ 5:15 下午$
 */
public class EqualPairs_2352 {

    public static int equalPairs(int[][] grid) {
        // 用map 存储每一行和每一列的值做为key
        // 存储一行值为key
        Map<String, Integer> lineMap = new HashMap<>();
        // 存储一列值为key
        Map<String, Integer> columnMap = new HashMap<>();

        int length = grid.length;
        for (int i = 0; i < length; i++) {
            String line = "";
            String column = "";
            for (int j = 0; j < length; j++) {
                line += (grid[i][j] + "-");
                column += (grid[j][i] + "-");
            }
            lineMap.put(line, lineMap.getOrDefault(line, 0) + 1);
            columnMap.put(column, columnMap.getOrDefault(column, 0) + 1);
        }

        AtomicInteger count = new AtomicInteger();
        lineMap.forEach((lineKey, lineValue) -> {
            Integer columnValue = columnMap.getOrDefault(lineKey, 0);
            count.addAndGet(lineValue * columnValue);
        });
        return count.get();
    }

    public static void main(String[] args) {
        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        int i = equalPairs(grid);
        System.out.println(i);
    }
}
