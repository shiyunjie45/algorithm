package com.sky.algorithmleetcode;

/*
有两种形状的瓷砖：一种是 2x1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。  XX  给定 N 的值，有多少种方法可以平铺 2 x N
 的面板？返回值 mod 10^9 + 7。 （平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个
平铺有一个瓷砖占据两个正方形。）  示例: 输入: 3 输出: 5 解释: 下面列出了五种不同的方法，不同字母代表不同瓷砖： XYZ XXZ XYY XXY X
YY XYZ YYZ XZZ XYY XXY 提示：  	N  的范围是 [1, 1000]
*/

 L790Solution {
    private static int MOD = 1000000007;

    public int numTilings(int N) {
        // 预先计算出 2 的幂次对 MOD 取模的值，方便后续使用
        int[] powTwoMod = new int[N + 3];
        powTwoMod[0] = 1;
        for (int i = 1; i <= N + 2; i++) {
            powTwoMod[i] = (powTwoMod[i - 1] << 1) % MOD;
        }

        int[] dp = new int[N + 3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        // 动态规划
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + powTwoMod[i - 3]) % MOD;
        }

        return dp[N];
    }
} 