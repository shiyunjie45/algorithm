package com.sky.algorithmleetcode;

/*
从具有 0 到 N-1 的结点的无向图（“原始图”）开始，对一些边进行细分。 该图给出如下：edges[k] 是整数对 (i, j, n) 组成的列表，使 (i
, j) 是原始图的边。 n 是该边上新结点的总数 然后，将边 (i, j) 从原始图中删除，将 n 个新结点 (x_1, x_2, ..., x_n) 添加到
原始图中， 将 n+1 条新边 (i, x_1), (x_1, x_2), (x_2, x_3), ..., (x_{n-1}, x_n), (x_n, j) 
添加到原始图中。 现在，你将从原始图中的结点 0 处出发，并且每次移动，你都将沿着一条边行进。 返回最多 M 次移动可以达到的结点数。   示例 1： 输入：e
dges = [[0,1,10],[0,2,1],[1,2,2]], M = 6, N = 3 输出：13 解释： 在 M = 6 次移动之后在最终图中可到达的
结点如下所示。  示例 2： 输入：edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], M = 10, N = 4 输出：23
   提示：  	0 	0 	不存在任何 i != j 情况下 edges[i][0] == edges[j][0] 且 edges[i][1] == edge
s[j][1]. 	原始图没有平行的边。 	0 	0 	1 	可到达结点是可以从结点 0 开始使用最多 M 次移动到达的结点。
*/

 java.util.*;

public class L882Solution {
    
    public int reachableNodes(int[][] edges, int M, int N) {
        // 构建邻接矩阵
        int[][] graph = new int[N][N];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            graph[u][v] = graph[v][u] = w;
        }
        // 用于记录结点从原点出发最远能走的步数
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[0] = 0;
        // 记录已遍历的结点
        boolean[] visited = new boolean[N];
        // 用于记录新加入的结点
        Map<Integer, Integer> extraNodes = new HashMap<>();
        // 构建小根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});
        // Dijkstra最短路径算法
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], d = cur[1];
            if (visited[node]) {
                // 如果结点已遍历，则跳过
                continue;
            }
            visited[node] = true;
            extraNodes.put(node, cur[2]);
            for (int nei = 0; nei < N; nei++) {
                if (graph[node][nei] > 0) {
                    int d2 = graph[node][nei];
                    if (d + d2 + 1 < dist[nei]) {
                        // 如果可以到达结点nei，则更新堆中的结果
                        dist[nei] = d + d2 + 1;
                        pq.offer(new int[]{nei, dist[nei], d2});
                    }
                }
            }
        }
        // 计算结果
        int res = 0;
        for (int d : dist) {
            if (d <= M) {
                // 结点直接可达
                res++;
            }
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int nodeU = extraNodes.getOrDefault(u, 0);
            int nodeV = extraNodes.getOrDefault(v, 0);
            // 计算有多少结点是通过细分边(u,v)到达的
            res += Math.min(w, M - dist[u] - nodeU) + Math.min(w, M - dist[v] - nodeV);
        }
        return res;
    }
} 