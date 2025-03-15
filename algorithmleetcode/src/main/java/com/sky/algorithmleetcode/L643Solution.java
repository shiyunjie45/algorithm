package com.sky.algorithmleetcode;

/*
给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 示例 1: 输入: [1,12,-5,-6,50,3], k = 4 输出: 
12.75 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75    注意:  	1 k n 	所给数据范围 [-10,000，10,
000]。
*/

 class L643Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }
} 