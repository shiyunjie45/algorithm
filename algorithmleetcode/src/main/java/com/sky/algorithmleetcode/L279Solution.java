package com.sky.algorithmleetcode;

/*
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 示例 1: 输入: 
n = 12 输出: 3 解释: 12 = 4 + 4 + 4. 示例 2: 输入: n = 13 输出: 2 解释: 13 = 4 + 9.
*/

import java.util.Arrays;

public class L279Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
} 