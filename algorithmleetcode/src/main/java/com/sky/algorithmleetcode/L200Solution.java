package com.sky.algorithmleetcode;

/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形
成。 此外，你可以假设该网格的四条边均被水包围。   示例 1: 输入: 11110 11010 11000 00000 输出: 1  示例 2: 输入: 11
000 11000 00100 00011 输出: 3 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
*/

 class L200Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n) return;
        if(grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
} 