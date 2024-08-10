package com.sky.algorithmleetcode;

/*
给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。 数学表达式如下: 如果存在这样的 i, j, k,  且满足 0 ≤ i j k ≤ n
-1， 使得 arr[i] arr[j] arr[k] ，返回 true ; 否则返回 false 。 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 
O(1) 。 示例 1: 输入: [1,2,3,4,5] 输出: true  示例 2: 输入: [5,4,3,2,1] 输出: false  ### 相似题目
 - 中等:	[最长上升子序列]
*/

 class L334Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }
        int[] dp = new int[3];
        int len = 0;
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= dp[0]) {
                dp[0] = nums[i];
            } else if(nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                dp[1] = nums[i];
            }
            if(len == 2) {
                return true;
            }
        }
        return false;
    }
} 