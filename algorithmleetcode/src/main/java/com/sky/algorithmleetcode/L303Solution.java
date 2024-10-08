package com.sky.algorithmleetcode;

/*
给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。 示例： 给定 nums = [-2, 0
, 3, -5, 2, -1]，求和函数为 sumRange() sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRan
ge(0, 5) -> -3 说明:  	你可以假设数组不可变。 	会多次调用 sumRange 方法。
*/

 class L303Solution {
    private int[] dp;

    public L303Solution(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return dp[j];
        } else {
            return dp[j] - dp[i - 1];
        }
    }
} 