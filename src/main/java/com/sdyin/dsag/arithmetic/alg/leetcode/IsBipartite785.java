package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description: 785. 判断二分图
 * 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。
 * 给你一个二维数组 graph ，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。
 * 形式上，对于graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
 * 不存在自环（graph[u] 不包含 u）。
 * 不存在平行边（graph[u] 不包含重复值）。
 * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
 * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
 *
 * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，
 * 并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
 *
 * 如果图是二分图，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/4/17$ 8:27 下午$
 */
public class IsBipartite785 {

    //记录结果
    private boolean ok = true;
    //记录图中节点的颜色， false和true代表两种不同颜色
    private boolean[] color;
    //记录图中节点是否被访问过
    private boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        //图的长度 实际就是节点的个数
        int n = graph.length;

        color = new boolean[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            //未访问过，则遍历
            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return ok;
    }

    /**
     * dfs 遍历节点
     * @param graph 图
     * @param v 节点
     */
    private void traverse(int[][] graph, int v) {
        //匹配到不满足的元素，即结束
        if (!ok) {
            return;
        }

        //标记当前节点已访问
        visited[v] = true;

        for (int w : graph[v]) {
            if (!visited[w]) {
                //未访问过，则需要标记上和v节点不一样的颜色(二分图需要一条边节点颜色不同)
                color[w] = !color[v];
                //继续遍历
                traverse(graph, w);
            } else {
                //已访问过，则需要判断相邻节点颜色
                if (color[v] == color[w]) {
                    //相同，即不满足
                    ok = false;
                    return;
                }
            }
        }

    }

}
