package com.sky.algorithmleetcode;

/*
给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。 注意: 数组长度 n 满
足以下条件:  	1 ≤ n ≤ 1000 	1 ≤ m ≤ min(50, n)  示例:  输入: nums = [7,2,5,10,8] m = 2 输出
: 18 解释: 一共有四种方法将nums分割为2个子数组。 其中最好的方式是将其分为[7,2,5] 和 [10,8]， 因为此时这两个子数组各自的和的最大值为
18，在所有情况中最小。
*/

 class L410Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[m + 1][n + 1];
        int[] sums = new int[n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = i - 1; k < j; k++) {
                    int val = Math.max(dp[i - 1][k], sums[j] - sums[k]);
                    dp[i][j] = Math.min(dp[i][j], val);
                }
            }
        }
        return dp[m][n];
    }
} 