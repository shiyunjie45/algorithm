package com.sky.algorithmleetcode;

/*
在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。 现在开始下雨了。当时间为 t 时，此时
雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默
认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (
N-1, N-1)？ 示例 1:  输入: [[0,2],[1,3]] 输出: 3 解释: 时间为0时，你位于坐标方格的位置为 (0, 0)。 此时你不能游向任
意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台
没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置  示例2:  输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,
15,16],[11,17,18,19,20],[10,9,8,7,6]] 输入: 16 解释: 0 1 2 3 4 24 23 22 21 5 12 13 1
4 15 16 11 17 18 19 20 10 9 8 7 6 最终的路线用加粗进行了标记。 我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 
(4, 4) 是连通的  提示:  	2 . 	grid[i][j] 位于区间 [0, ..., N*N - 1] 内。
*/

 java.util.*;

public class L778Solution {

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int l = Math.max(grid[0][0], grid[N - 1][N - 1]);
        int r = N * N - 1;
        while (l <= r) {
            int mid = (l + r) / 2;  // 二分查找
            boolean[][] visited = new boolean[N][N];
            if (dfs(0, 0, mid, visited, grid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // DFS递归
    public boolean dfs(int x, int y, int limit, boolean[][] visited, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] > limit) {
            return false;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return true;
        }
        visited[x][y] = true;
        return dfs(x - 1, y, limit, visited, grid) || dfs(x + 1, y, limit, visited, grid)
                || dfs(x, y - 1, limit, visited, grid) || dfs(x, y + 1, limit, visited, grid);
    }

} 