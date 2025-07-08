package com.sky.algorithmleetcode;

/*
给定一个无向图graph，当这个图为二分图时返回true。 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，
一个来自B集合，我们就将这个图称为二分图。 graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.l
ength-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。  示例 1: 输入: [[1,3], [
0,2], [1,3], [0,2]] 输出: true 解释: 无向图如下: 0----1 |  | |  | 3----2 我们可以将节点分成两组: {0,
 2} 和 {1, 3}。   示例 2: 输入: [[1,2,3], [0,2], [0,1,3], [0,2]] 输出: false 解释: 无向图如下: 
0----1 | \ | | \ | 3----2 我们不能将节点分割成两个独立的子集。  注意:  	graph 的长度范围为 [1, 100]。 	grap
h[i] 中的元素的范围为 [0, graph.length - 1]。 	graph[i] 不会包含 i 或者有重复的值。 	图是无向的: 如果j 在 gra
ph[i]里边, 那么 i 也会在 graph[j]里边。
*/

 java.util.*;

public class L785Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 记录每个节点的颜色，1表示一组，-1表示另一组，0表示未染色
        Arrays.fill(colors, 0);
        for (int i = 0; i < n; i++) { // 对于每个未染色的节点，进行DFS染色操作
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int curNode, int curColor) {
        colors[curNode] = curColor; // 染色
        for (int neighbor : graph[curNode]) { // 检查当前节点的邻居节点
            if (colors[neighbor] == curColor) return false; // 如果邻居节点的颜色和当前节点相同，则不满足二分图定义
            if (colors[neighbor] == 0 && !dfs(graph, colors, neighbor, -curColor)) return false; // 对未染色的邻居节点进行染色
        }
        return true;
    }
} 