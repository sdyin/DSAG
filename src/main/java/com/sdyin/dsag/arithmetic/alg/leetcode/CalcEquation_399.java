package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.*;

/**
 * @Description: leetcode.399. 除法求值
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
 * @Author: liuye
 * @time: 2023/12/18$ 3:35 下午$
 */
public class CalcEquation_399 {

    /**
     * 暂未理解...
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 保存图的邻接表，key是变量，value是与其相连的边和权值
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // 构建有向图
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, value);
            graph.computeIfAbsent(to, k -> new HashMap<>()).put(from, 1 / value);
        }

        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            results[i] = dfs(graph, start, end, new HashSet<>(), 1.0);
        }

        return results;
    }

    // 深度优先搜索（DFS）计算结果
    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited, double currResult) {
        if (!graph.containsKey(start) || !visited.add(start)) {
            return -1.0; // 无法确定的答案，返回-1.0
        }

        if (start.equals(end)) {
            return currResult; // 找到结果，返回当前结果
        }

        Map<String, Double> neighbors = graph.get(start);
        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            double result = dfs(graph, neighbor.getKey(), end, visited, currResult * neighbor.getValue());
            if (result != -1.0) {
                return result; // 找到结果，返回结果
            }
        }

        return -1.0; // 无法确定的答案，返回-1.0
    }

    public static void main(String[] args) {
        CalcEquation_399 solution = new CalcEquation_399();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        double[] results = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(results)); // Output: [6.00000, 0.50000, -1.00000, 1.00000]
    }
}
