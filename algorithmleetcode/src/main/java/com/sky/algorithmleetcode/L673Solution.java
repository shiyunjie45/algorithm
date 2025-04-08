package com.sky.algorithmleetcode;

/*
给定一个未排序的整数数组，找到最长递增子序列的个数。 示例 1:  输入: [1,3,5,4,7] 输出: 2 解释: 有两个最长递增子序列，分别是 [1, 3
, 4, 7] 和[1, 3, 5, 7]。  示例 2:  输入: [2,2,2,2,2] 输出: 5 解释: 最长递增子序列的长度是1，并且存在5个子序列的
长度为1，因此输出5。  注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
*/

 class L673Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length]; //dp[i]表示以第i个元素结尾的最长递增子序列的长度
        int[] count = new int[nums.length]; //count[i]表示以第i个元素结尾的最长递增子序列的数量
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) { //发现更长的递增序列
                        dp[i] = dp[j] + 1;
                        count[i] = count[j]; //数量和之前相等
                    }
                    else if (dp[j] + 1 == dp[i]) { //添加一个相同长度的递增序列
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == maxLen) {
                res += count[i]; //统计最长递增序列的数量
            }
        }
        return res;
    }
} 