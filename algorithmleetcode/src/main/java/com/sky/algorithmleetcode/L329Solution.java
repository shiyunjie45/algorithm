package com.sky.algorithmleetcode;

/*
给定一个整数矩阵，找出最长递增路径的长度。 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。 示例
 1: 输入: nums = [  [9,9,4],  [6,6,8],  [2,1,1] ] 输出: 4 解释: 最长递增路径为 [1, 2, 6, 9]。 
示例 2: 输入: nums = [  [3,4,5],  [3,2,6],  [2,2,1] ] 输出: 4 解释: 最长递增路径是 [3, 4, 5, 6]
。注意不允许在对角线方向上移动。
*/

 class L329Solution {
    int[][] memo;
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int x, int y) {
        if (memo[x][y] != 0) return memo[x][y];
        memo[x][y] = 1;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (matrix[nx][ny] > matrix[x][y]) {
                memo[x][y] = Math.max(memo[x][y], dfs(matrix, nx, ny) + 1);
            }
        }
        return memo[x][y];
    }
} 