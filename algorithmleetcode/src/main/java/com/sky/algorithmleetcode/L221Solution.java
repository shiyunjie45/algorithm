package com.sky.algorithmleetcode;

/*
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 示例: 输入:  1 0 1 0 0 1 0 1 1 1 1 1 1 1 
1 1 0 0 1 0 输出: 4
*/

 class L221Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int sideLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    sideLen = Math.max(sideLen, dp[i][j]);
                }
            }
        }
        return sideLen * sideLen;
    }
} 