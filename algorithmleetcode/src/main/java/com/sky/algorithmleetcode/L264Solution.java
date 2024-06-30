package com.sky.algorithmleetcode;

/*
编写一个程序，找出第 n 个丑数。 丑数就是质因数只包含 2, 3, 5 的正整数。 示例: 输入: n = 10 输出: 12 解释: 1, 2, 3, 4,
 5, 6, 8, 9, 10, 12 是前 10 个丑数。 说明:    	1 是丑数。 	n 不超过1690。
*/

 class L264Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;

        int[] dp = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        dp[0] = 1;

        for(int i = 1; i < n; i++){
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if(dp[i] == dp[p2] * 2) p2++;
            if(dp[i] == dp[p3] * 3) p3++;
            if(dp[i] == dp[p5] * 5) p5++;
        }
        return dp[n - 1];
    }
} 