package com.sdyin.dsag.arithmetic.alg.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1267. 统计参与通信的服务器
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 *
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 *
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 * @Author: liuye
 * @time: 2023/8/24$ 5:21 下午$
 */
public class CountServers_1267 {

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,1,0},{0,0,0,0,0}, {0,0,0,1,0}};
        int i = countServers(grid);
        System.out.println(i);
    }

    /**
     * 思路： 先遍历行，再遍历列。
     * 遍历行时标记满足的元素个数，遍历列时需要剔除遍历行时已经标记使用的元素。
     *
     * @param grid
     * @return
     */
    public static int countServers(int[][] grid) {
        int result = 0;
        Map<String, Boolean> map = new HashMap<>();
        //遍历行
        for (int i = 0; i < grid.length; i++) {
            int flag = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    flag++;
                    map.put(i + "-" + j, false);
                }
            }
            if (flag > 1){
                result += flag;
                for (String key : map.keySet()) {
                    String keyPre = key.split("-")[0];
                    if (keyPre.equals(i + "")){
                        map.put(key, true);
                    }
                }
            }
        }
        // 遍历列
        for (int i = 0; i < grid[0].length; i++) {
            int flag = 0;
            int flag2 = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1){
                    flag++;
                    if ((!map.containsKey(j + "-" + i)) || (!map.get(j + "-" + i))){
                        flag2++;
                    }
                }
            }
            if (flag > 1){
                result += flag2;
            }
        }
        return result;
    }
}
