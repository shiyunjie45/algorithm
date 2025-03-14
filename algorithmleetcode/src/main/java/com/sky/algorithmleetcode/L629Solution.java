package com.sky.algorithmleetcode;

/*
给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。 逆序对的定义如下：对于数组的第i个和第 j个元素，如
果满i j且 a[i] > a[j]，则其为一个逆序对；否则不是。 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。 示例 1:  输入: n
 = 3, k = 0 输出: 1 解释: 只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。  示例 2:  输入: n = 3, k
 = 1 输出: 2 解释: 数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。  说明:  	 n 的范围是 [1, 1000] 并且 k 的范围
是 [0, 1000]。
*/

 class L629Solution {
    private static final int MOD = 1000000007;

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[2][k + 1];
        dp[0][0] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            int idx = i % 2;
            int prevIdx = (i - 1) % 2;
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[idx][j] = 1;
                } else {
                    sum = (sum + dp[prevIdx][j - 1]) % MOD;
                    if (j >= i) {
                        sum = (sum - dp[prevIdx][j - i] + MOD) % MOD;
                    }
                    dp[idx][j] = (dp[idx][j - 1] + sum) % MOD;
                }
            }
        }
        return dp[n % 2][k];
    }
} 