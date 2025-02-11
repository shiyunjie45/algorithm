package com.sky.algorithmleetcode;

/*
给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最
多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。     示例 1：  输入: m = 2, n 
= 2, N = 2, i = 0, j = 0 输出: 6 解释:    示例 2：  输入: m = 1, n = 3, N = 3, i = 0, j =
 1 输出: 12 解释:       说明:   	球一旦出界，就不能再被移动回网格内。 	网格的长度和高度在 [1,50] 的范围内。 	N 在 [0,50
] 的范围内。
*/

 class L576Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int mod = 1000000007;
        int[][][] dp = new int[N+1][m][n];
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int k = 1; k <= N; k++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    for (int[] dir : directions) {
                        int ni = x + dir[0];
                        int nj = y + dir[1];
                        if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                            dp[k][x][y] += 1;
                        } else {
                            dp[k][x][y] = (dp[k][x][y] + dp[k-1][ni][nj]) % mod;
                        }
                    }
                }
            }
        }
        return dp[N][i][j];
    }
} 