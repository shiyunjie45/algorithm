package com.sky.algorithmleetcode;

/*
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。   示例 1: 输入: [2,3,
-2,4] 输出: 6 解释: 子数组 [2,3] 有最大乘积 6。  示例 2: 输入: [-2,0,-1] 输出: 0 解释: 结果不能为 2, 因为 [-
2,-1] 不是子数组。
*/

 class L152Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], nums[i]), min * nums[i]);
            min = Math.min(Math.min(temp * nums[i], nums[i]), min * nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
} 