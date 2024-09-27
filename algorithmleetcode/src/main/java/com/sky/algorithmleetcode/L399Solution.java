package com.sky.algorithmleetcode;

/*
给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回
 -1.0。 示例 : 给定 a / b = 2.0, b / c = 3.0 问题: a / c = ?, b / a = ?, a / e = ?, a /
 a = ?, x / x = ?  返回 [6.0, 0.5, -1.0, 1.0, -1.0 ] 输入为: vector> equations, vecto
r& values, vector> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.size(
)，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector类型。 基于上述例子，输入如下：  eq
uations(方程式) = [ ["a", "b"], ["b", "c"] ], values(方程式结果) = [2.0, 3.0], queries(问
题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].  输入总是有效的
。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
*/

 java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L399Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values); //建图
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {  //遍历所有查询
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, graph, new HashMap<>());
        }
        return res;
    }

    private double dfs(String start, String end, double value, Map<String, Map<String, Double>> graph, Map<String, Boolean> visited) {
        if (!graph.containsKey(start) || visited.containsKey(start)) { // 若连通图中不含起始节点或节点已被访问过，则无解
            return -1.0;
        }
        if (start.equals(end)) { // 起始节点等于目标节点，则路径已找到，返回路径结果
            return value;
        }
        visited.put(start, true); // 标记该节点已访问
        Map<String, Double> neighbors = graph.get(start); // 获取该节点的所有邻居
        for (Map.Entry<String, Double> entry : neighbors.entrySet()) { // 遍历邻居节点
            double subValue = entry.getValue(); // 子路径的权重值
            String subNode = entry.getKey(); // 子路径的终止节点
            double res = dfs(subNode, end, value * subValue, graph, visited); // 递归搜索子路径
            if (res != -1.0) { // 如果子路径有解，直接返回子路径结果
                return res;
            }
        }
        return -1.0; // 如果所有子路径都无解，则该路径无解
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>(); //建立图
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0), end = equations.get(i).get(1);
            double value = values[i];
            if (!graph.containsKey(start)) {
                graph.put(start, new HashMap<>());
            }
            graph.get(start).put(end, value);
            if (!graph.containsKey(end)) {
                graph.put(end, new HashMap<>());
            }
            graph.get(end).put(start, 1 / value);
        }
        return graph;
    }
} 