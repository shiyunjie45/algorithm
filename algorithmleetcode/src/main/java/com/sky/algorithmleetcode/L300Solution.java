package com.sky.algorithmleetcode;

/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。 示例: 输入: [10,9,2,5,3,7,101,18] 输出: 4 解释: 最长的上升子序列是 [2
,3,7,101]，它的长度是 4。 说明:  	可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 	你算法的时间复杂度应该为 O(n2) 。  
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
*/

 class L300Solution {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
} 