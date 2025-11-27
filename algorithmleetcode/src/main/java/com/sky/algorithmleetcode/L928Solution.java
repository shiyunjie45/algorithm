package com.sky.algorithmleetcode;

/*
(这个问题与 尽量减少恶意软件的传播 是一样的，不同之处用粗体表示。) 在节点网络中，只有当 graph[i][j] = 1 时，每个节点 i 能够直接连接到另
一个节点 j。 一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶
意软件的传播将继续，直到没有更多的节点可以被这种方式感染。 假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。 我们可以
从初始列表中删除一个节点，并完全移除该节点以及从该节点到任何其他节点的任何连接。如果移除这一节点将最小化 M(initial)， 则返回该节点。如果有多个节点满
足条件，就返回索引最小的节点。     示例 1： 输出：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1] 
输入：0  示例 2： 输入：graph = [[1,1,0],[1,1,1],[0,1,1]], initial = [0,1] 输出：1  示例 3： 输入
：graph = [[1,1,0,0],[1,1,1,0],[0,1,1,1],[0,0,1,1]], initial = [0,1] 输出：1    提示： 
 	1 	0 	graph[i][i] = 1 	1 	0
*/

 java.util.*;

public class L928Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int[] color = new int[n]; // 标记每个节点属于哪个联通块
        Arrays.fill(color, -1); // 初始化为未标记状态
        int cnt = 0; // 联通块数量
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                dfs(graph, color, i, cnt++);
            }
        }
        int[] size = new int[cnt]; // 记录每个联通块的大小
        for (int i = 0; i < n; i++) {
            size[color[i]]++;
        }
        int[] infected = new int[cnt]; // 记录每个联通块感染的初始节点数量
        for (int i : initial) {
            infected[color[i]]++;
        }
        int res = Integer.MAX_VALUE;
        int maxInfected = -1;
        for (int i : initial) {
            int c = color[i];
            if (infected[c] == 1) { // 只考虑感染的初始节点恰好在这个联通块中的情况
                if (maxInfected < size[c]) { // 先比较感染数量
                    maxInfected = size[c];
                    res = i;
                } else if (maxInfected == size[c]) { // 如果数量相等，再比较节点索引
                    res = Math.min(res, i);
                }
            }
        }
        if (res == Integer.MAX_VALUE) { // 如果没有合适的节点，则返回最小索引的初始节点
            for (int i : initial) {
                res = Math.min(res, i);
            }
        }
        return res;
    }

    // 深度优先搜索，标记联通块
    private void dfs(int[][] graph, int[] color, int node, int cnt) {
        color[node] = cnt;
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1 && color[i] == -1) {
                dfs(graph, color, i, cnt);
            }
        }
    }
} 