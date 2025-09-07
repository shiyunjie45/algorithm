package com.sky.algorithmleetcode;

/*
给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。  graph.length = N，且只有节点 i 和 j 连通
时，j != i 在列表 graph[i] 中恰好出现一次。 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用
边。     示例 1： 输入：[[1,2,3],[0],[0],[0]] 输出：4 解释：一个可能的路径为 [1,0,2,0,3] 示例 2： 输入：[[1]
,[0,2,4],[1,3,4],[2],[1,2]] 输出：4 解释：一个可能的路径为 [0,1,4,2,3]    提示：  	1 	0
*/

public class L847Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        // dp[i][j]表示以i节点为最后一个经过的节点，并且经过的节点集合为j的最短路径长度
        int[][] dp = new int[n][(1 << n)];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE >> 1);
            dp[i][1 << i] = 0;
            queue.offer(new int[]{i, 1 << i});
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int idx = node[0], status = node[1];
            if (status == (1 << n) - 1) {
                return dp[idx][status];
            }
            for (int next : graph[idx]) {
                int nextStatus = status | (1 << next);
                if (dp[next][nextStatus] > dp[idx][status] + 1) {
                    dp[next][nextStatus] = dp[idx][status] + 1;
                    queue.offer(new int[]{next, nextStatus});
                }
            }
        }

        return -1;
    }
} 