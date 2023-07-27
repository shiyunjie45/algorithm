package com.sky.algorithmleetcode;

/*
给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。 示例 1: 输入: s1 = "aabcc", s2 = "dbbc
a", s3 = "aadbbcbcac" 输出: true  示例 2: 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadb
bbaccc" 输出: false
*/

 class L97Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) return false;

        boolean[][] dp = new boolean[n1+1][n2+1];
        for (int i = 0; i <= n1; ++i) {
            for (int j = 0; j <= n2; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                } else {
                    dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                                (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                }
            }
        }
        return dp[n1][n2];
    }
} 