package com.sky.algorithmleetcode;

/*
给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是
一个整数。 示例 1: 输入: [23,2,4,6,7], k = 6 输出: True 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。  示例
 2: 输入: [23,2,6,4,7], k = 6 输出: True 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。  说明:  
	数组的长度不会超过10,000。 	你可以认为所有数字总和在 32 位有符号整数范围内。
*/

 class L523Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = sum[j] - sum[i] + nums[i];
                if (k == 0) {
                    if (temp == 0) {
                        return true;
                    }
                } else {
                    if (temp % k == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
} 