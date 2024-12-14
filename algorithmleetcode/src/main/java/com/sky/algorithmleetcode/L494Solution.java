package com.sky.algorithmleetcode;

/*
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一
个符号添加在前面。 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 示例 1: 输入: nums: [1, 1, 1, 1, 1], S: 3 输出
: 5 解释:  -1+1+1+1+1 = 3 +1-1+1+1+1 = 3 +1+1-1+1+1 = 3 +1+1+1-1+1 = 3 +1+1+1+1-1 
= 3 一共有5种方法让最终目标和为3。  注意:  	数组非空，且长度不会超过20。 	初始的数组的和不会超过1000。 	保证返回的最终结果能被32位整数存
下。
*/

 class L494Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || S < -sum) {
            return 0;
        }
        int[][] dp = new int[nums.length][2 * sum + 1];
        dp[0][sum + nums[0]] = 1;
        dp[0][sum - nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (dp[i - 1][j + sum] > 0) {
                    dp[i][j + nums[i] + sum] += dp[i - 1][j + sum];
                    dp[i][j - nums[i] + sum] += dp[i - 1][j + sum];
                }
            }
        }
        return dp[nums.length - 1][S + sum];
    }
} 