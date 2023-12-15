package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: leetcode 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。
 * 如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 * @Author: liuye
 * @time: 2023/12/15$ 5:35 下午$
 */
public class FindCircleNum_547 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        //记录省份数量
        int count = 0;
        //记录是否访问过
        boolean[] visited = new boolean[n];
        //遍历每个城市
        for (int i = 0; i < n; i++) {
            //如果没访问过，则说明是新的省份
            if(!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }

        return count;
    }

    /**
     * 深度优先遍历
     * @param isConnected
     * @param visited 标记是否访问过数组
     * @param i
     */
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        //遍历第i行,j代表列
        for (int j = 0; j < isConnected.length; j++) {
            //如果第i行第j列为1(直接相连)，且第j个城市没访问过没访问过，则继续遍历第j个城市
            if(isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }

}
