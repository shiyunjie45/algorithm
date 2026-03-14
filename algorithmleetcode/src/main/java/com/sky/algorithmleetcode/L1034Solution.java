package com.sky.algorithmleetcode;

/*
给出一个二维整数网格 grid，网格中的每个值表示该位置处的网格块的颜色。 只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一连通分
量。 连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。 给出位
于 (r0, c0) 的网格块和颜色 color，使用指定颜色 color 为所给网格块的连通分量的边界进行着色，并返回最终的网格 grid 。   示例 1：
 输入：grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3 输出：[[3, 3], [3, 2]]  示例 2： 输
入：grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3 输出：[[1, 3, 3], [2, 3, 3]] 
 示例 3： 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2 输出：[[2, 2,
 2], [2, 1, 2], [2, 2, 2]]   提示：  	1 	1 	1 	0 	0 	1
*/

 class L1034Solution {
    //定义四个方向
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int oldColor = grid[r0][c0];
        //使用两个队列存储边界坐标和染色坐标
        LinkedList<int[]> borderQueue = new LinkedList<>();
        borderQueue.offer(new int[]{r0, c0});

        LinkedList<int[]> colorQueue = new LinkedList<>();

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[r0][c0] = true;

        while (!borderQueue.isEmpty()) {
            int[] cur = borderQueue.poll();
            boolean isEdge = false;
            for (int[] dir : directions) {
                int newRow = cur[0] + dir[0];
                int newCol = cur[1] + dir[1];
                if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length) {
                    //如果该方向是边界
                    isEdge = true;
                } else if (!visited[newRow][newCol] && grid[newRow][newCol] == oldColor) {
                    visited[newRow][newCol] = true;
                    borderQueue.offer(new int[]{newRow, newCol});
                }
            }
            if (isEdge) {
                colorQueue.offer(cur);
            }
        }
        while (!colorQueue.isEmpty()) {
            int[] cur = colorQueue.poll();
            if (cur[0] == r0 && cur[1] == c0) {
                //特殊情况，染色坐标就是初始坐标，改变的是初始颜色
                grid[cur[0]][cur[1]] = color;
                continue;
            }
            int onlyEdgeCount = 0;
            for (int[] dir : directions) {
                int newRow = cur[0] + dir[0];
                int newCol = cur[1] + dir[1];
                if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || 
                    !visited[newRow][newCol] || grid[newRow][newCol] == oldColor) {
                    onlyEdgeCount++;
                }
                if (onlyEdgeCount == 4) {
                    //如果交点四周的格子都不是边界，那么交点就在内部，不需要染色
                    break;
                }
            }
            if (onlyEdgeCount < 4) {
                //交点至少有一个方向在边界上，需要染色
                grid[cur[0]][cur[1]] = color;
            }
        }
        return grid;
    }
} 