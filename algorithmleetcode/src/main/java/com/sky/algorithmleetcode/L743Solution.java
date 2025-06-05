package com.sky.algorithmleetcode;

/*
有 N 个网络节点，标记为 1 到 N。 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点
，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。 现在，我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收
到信号，返回 -1。   示例：  输入：times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2 输出：2    注意:
  	N 的范围在 [1, 100] 之间。 	K 的范围在 [1, N] 之间。 	times 的长度在 [1, 6000] 之间。 	所有的边 times[
i] = (u, v, w) 都有 1  且 0 。
*/

 java.util.Arrays;
import java.util.PriorityQueue;

public class L743Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // 构建邻接矩阵
        int[][] graph = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph[u][v] = w;
        }
        // Dijkstra算法，使用优先队列寻找最小值
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, K});
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curDist = cur[0], u = cur[1];
            if (curDist > dist[u]) continue;
            for (int v = 1; v <= N; v++) {
                int weight = graph[u][v];
                if (weight == Integer.MAX_VALUE) continue;
                int newDist = dist[u] + weight;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, dist[i]);
        }
        return res;
    }
} 