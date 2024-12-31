package com.sky.algorithmleetcode;

/*
给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。 示例 1: 输入:  "bbbab"  输出:  4  一个可能的最长回文子序列为
 "bbbb"。 示例 2: 输入:  "cbbd"  输出:  2  一个可能的最长回文子序列为 "bb"。
*/

 class L516Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n]; // dp数组记录最长回文子序列的长度
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1; // 初始化，单个字符的最长回文子序列长度为1
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2; // 如果s[i]==s[j]，则s[i, j]是回文子序列，长度为dp[i + 1][j - 1] + 2
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); // 如果s[i]!=s[j]，则s[i, j]不是回文子序列，长度为Math.max(dp[i + 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[0][n - 1]; // 返回s[0, n-1]的最长回文子序列长度
    }
} 