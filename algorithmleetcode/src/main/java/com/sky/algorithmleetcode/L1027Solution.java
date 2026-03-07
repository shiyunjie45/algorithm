package com.sky.algorithmleetcode;

/*
给定一个整数数组 A，返回 A 中最长等差子序列的长度。 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 。并且
如果 B[i+1] - B[i]( 0 ) 的值都相同，那么序列 B 是等差的。   示例 1： 输入：[3,6,9,12] 输出：4 解释： 整个数组是公差为
 3 的等差数列。  示例 2： 输入：[9,4,7,2,10] 输出：3 解释： 最长的等差子序列是 [4,7,10]。  示例 3： 输入：[20,1,15
,3,10,5,8] 输出：4 解释： 最长的等差子序列是 [20,15,10,5]。    提示：  	2 	0
*/

 class L1027Solution {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }
        int n = A.length;
        //dp[i][j]: 以A[i]为结尾，公差为j的等差子序列的长度
        int[][] dp = new int[n][20001];
        int res = 0;
        //对于每个i，考虑i之前的元素j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int d = A[i] - A[j] + 10000;
                //如果j之前存在公差为d的等差子序列，则将其加入以A[i]为结尾的等差子序列，并更新长度
                if (dp[j][d] > 0) {
                    dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1);
                } else {
                    dp[i][d] = 2;
                }
                //更新全局最长等差子序列长度
                res = Math.max(res, dp[i][d]);
            }
        }
        return res;
    }
} 