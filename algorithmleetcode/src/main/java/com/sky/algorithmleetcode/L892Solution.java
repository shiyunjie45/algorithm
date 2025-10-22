package com.sky.algorithmleetcode;

/*
在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j)
 上。 请你返回最终形体的表面积。     示例 1： 输入：[[2]] 输出：10  示例 2： 输入：[[1,2],[3,4]] 输出：34  示例 3： 
输入：[[1,0],[0,2]] 输出：16  示例 4： 输入：[[1,1,1],[1,0,1],[1,1,1]] 输出：32  示例 5： 输入：[[2,2
,2],[2,1,2],[2,2,2]] 输出：46    提示：  	1 	0
*/

 class L892Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    res += 2; // 上下两个面积
                    // 四个方向判断是否可以贡献面积
                    res += i == 0 ? grid[i][j] : Math.max(grid[i][j] - grid[i-1][j], 0);
                    res += j == 0 ? grid[i][j] : Math.max(grid[i][j] - grid[i][j-1], 0);
                    res += i == n - 1 ? grid[i][j] : Math.max(grid[i][j] - grid[i+1][j], 0);
                    res += j == n - 1 ? grid[i][j] : Math.max(grid[i][j] - grid[i][j+1], 0);
                }
            }
        }
        
        return res;
    }
} 