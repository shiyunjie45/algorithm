package com.sky.algorithmleetcode;

/*
在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。 每个值 v = grid[i][j] 表示 v 个正方体叠放在
单元格 (i, j) 上。 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。 投影就像影子，将三维形体映射到一个二维平面上。 在这里，从顶部、前
面和侧面看立方体时，我们会看到“影子”。 返回所有三个投影的总面积。         示例 1： 输入：[[2]] 输出：5  示例 2： 输入：[[1,2],
[3,4]] 输出：17 解释： 这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。  示例 3： 输入：[[1,0],[0,2]] 输出：8  示例 
4： 输入：[[1,1,1],[1,0,1],[1,1,1]] 输出：14  示例 5： 输入：[[2,2,2],[2,1,2],[2,2,2]] 输出：21 
   提示：  	1 	0
*/

 L883Solution {
    public int projectionArea(int[][] grid) {
        int N = grid.length;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            int bestRow = 0;  // xy平面
            int bestCol = 0;  // yz平面
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] != 0) {
                    ans++;  // 顶部投影
                }
                bestRow = Math.max(bestRow, grid[i][j]);
                bestCol = Math.max(bestCol, grid[j][i]);
            }
            ans += bestRow + bestCol;  // 加上xy和yz两个面的投影
        }

        return ans;
    }
} 