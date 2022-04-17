package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 886. 可能的二分法
 * 给定一组n人（编号为1, 2, ..., n），我们想把每个人分进任意大小的两组。
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * <p>
 * 给定整数 n和数组 dislikes，其中dislikes[i] = [ai, bi]，表示不允许将编号为 ai和bi的人归入同一组。
 * 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/possible-bipartition
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/4/17$ 9:16 下午$
 */
public class PossibleBipartition886 {

    private boolean res = true;

    private boolean[] visited;

    private boolean[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        //编号从1开始
        visited = new boolean[n + 1];
        color = new boolean[n + 1];

        //将二维数组转换为邻接表表示图结构
        List<Integer>[] graph = buildGraph(n, dislikes);

        for (int i = 1; i < n + 1; i++) {
            //未访问过的才递归遍历
            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return res;
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        // 图节点编号为 1...n
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : dislikes) {
            int w =  edge[0];
            int v = edge[1];
            //edge 中两个节点组成一条线(二分图)
            // 无向图 相当于 双向图,所以要互相添加
            graph[w].add(v);
            graph[v].add(w);
        }
        return graph;
    }

    private void traverse(List<Integer>[] graph, int v) {
        //已经不匹配，无需再遍历
        if (!res) {
            return;
        }

        //标记已访问过
        visited[v] = true;

        for (int w : graph[v]) {
            //已访问过
            if (visited[w]) {
                if (color[w] == color[v]) {
                    //颜色相同，不符合
                    res = false;
                    return;
                }
            } else {
                //未访问过
                color[w] = !color[v];
                traverse(graph, w);
            }

        }
    }
}
