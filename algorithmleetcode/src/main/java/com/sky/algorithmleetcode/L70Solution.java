package com.sky.algorithmleetcode;

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 注意：给定 n 是一个正整数。 示例 1
： 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1. 1 阶 + 1 阶 2. 2 阶 示例 2： 输入： 3 输出： 3 解释： 有三种方法可以
爬到楼顶。 1. 1 阶 + 1 阶 + 1 阶 2. 1 阶 + 2 阶 3. 2 阶 + 1 阶
*/

 class L70Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        // dp[i]表示到第i个台阶有多少种方法
        dp[1] = 1; // 到第1个有1种方法
        dp[2] = 2; // 到第2个有2种方法
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2]; // 到第i个有 1.从i-1个上 2.从i-2个上 这两种方法
        }
        return dp[n];
    }
} 