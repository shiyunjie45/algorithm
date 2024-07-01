package com.sky.algorithmleetcode;

/*
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。 示例 1: 输入: [3,0,1] 输出: 
2  示例 2: 输入: [9,6,4,2,3,5,7,0,1] 输出: 8  说明: 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
*/

 class L268Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = (0 + n) * (n + 1) / 2; // 求 0~n 的和
        int sum2 = 0;
        for (int num : nums) {  // 求 nums 数组的和
            sum2 += num;
        }
        return sum1 - sum2; // 两者之差即为缺失的数
    }
} 