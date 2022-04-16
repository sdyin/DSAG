package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 797. 所有可能的路径
 * 给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
 *
 * graph[i]是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点graph[i][j]存在一条有向边）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2022/4/16$ 8:41 下午$
 */
public class AllPathsSourceTarget797 {

    //记录所有可能的路径
    private static List<List<Integer>> allPath = new LinkedList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //维护递归过程中经过的路径,使用linkedList 双向链表，方便队尾进队尾出
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return allPath;
    }

    private static void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        //添加节点到路径
        path.addLast(s);

        int n = graph.length;
        //到达终点，终点即是 n-1
        if (s == n - 1) {
            //java值传递，所以需要新建链表加入
            allPath.add(new LinkedList<>(path));

            //移除最后一个元素，并结束响应，不移除的话会影响其他多叉节点
            path.removeLast();
            return;
        }

        //当前所在节点可到达节点集合
        int[] indexList = graph[s];
        for (int v : indexList) {
            //继续遍历
            traverse(graph, v, path);
        }

        // 路径中移除节点s,为什么要移除？ 因为走到底了还是不能到达目标节点，说明当前节点不是一条有效正确路径节点
        path.removeLast();
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        final List<List<Integer>> lists = allPathsSourceTarget(graph);
        System.out.println(lists);
    }
}
