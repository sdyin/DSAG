package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.*;

/**
 * @Description: leetcode 1466. 重新规划路线
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。
 * 因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。
 * 去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 *
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 *
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 *
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 *
 * 示例 1：
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 *
 * 示例 2：
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 *
 * 示例 3：
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 *
 *
 * @Author: liuye
 * @time: 2023/12/18$ 11:49 上午$
 */
public class MinReorder_1466 {

    public int minReorder(int n, int[][] connections) {
        // 创建图的邻接表表示
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // 填充图的邻接表
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];

            // 添加原始方向的边（方向为1）
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, 1});
            // 添加反向的边（方向为0，表示需要改变方向）
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new int[]{from, 0});
        }

        // 进行深度优先搜索（DFS），计算需要改变方向的最小路线数
        return dfs(graph, new HashSet<>(), 0);
    }

    // 深度优先搜索（DFS）方法
    private int dfs(Map<Integer, List<int[]>> graph, Set<Integer> visited, int city) {
        // 标记当前城市为已访问
        visited.add(city);
        // 记录需要改变方向的路线数
        int changeDirection = 0;

        // 如果当前城市在图中存在连接的城市
        if (graph.containsKey(city)) {
            // 遍历当前城市的邻接城市
            for (int[] neighbor : graph.get(city)) {
                int nextCity = neighbor[0];
                int direction = neighbor[1]; // 方向（1表示原始方向，0表示需要改变方向）

                // 如果邻接城市未被访问，则递归调用DFS，并累加需要改变方向的路线数
                if (!visited.contains(nextCity)) {
                    changeDirection += direction + dfs(graph, visited, nextCity);
                }
            }
        }

        return changeDirection; // 返回需要改变方向的路线数
    }
}
