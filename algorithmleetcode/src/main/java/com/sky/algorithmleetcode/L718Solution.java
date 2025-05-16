package com.sky.algorithmleetcode;

/*
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 示例 1:  输入: A: [1,2,3,2,1] B: [3,2,1,4,7] 
输出: 3 解释: 长度最长的公共子数组是 [3, 2, 1]。  说明:  	1 	0
*/

 class L718Solution {
    public int findLength(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length;
        int ans = 0;
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = lenA - 1; i >= 0; i--) {
            for (int j = lenB - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
} 