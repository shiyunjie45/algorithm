package com.sky.algorithmleetcode;

/*
给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。   示例： 给出如下 3x6 的高度图
: [  [1,4,3,1,3,2],  [3,2,1,3,2,4],  [2,3,3,2,3,1] ] 返回 4 。   如上图所示，这是下雨前的高度图[[1
,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。    下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。   提
示：  	1 	0
*/

 L407Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
        }
        for (int i = 1; i < n - 1; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            pq.offer(new int[]{0, i, heightMap[0][i]});
            pq.offer(new int[]{m - 1, i, heightMap[m - 1][i]});
        }
        int res = 0;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                res += Math.max(0, cur[2] - heightMap[x][y]);
                pq.offer(new int[]{x, y, Math.max(heightMap[x][y], cur[2])});
            }
        }
        return res;
    }
} 