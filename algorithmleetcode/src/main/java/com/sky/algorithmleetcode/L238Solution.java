package com.sky.algorithmleetcode;

/*
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其
余各元素的乘积。   示例: 输入: [1,2,3,4] 输出: [24,12,8,6]   提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个
数组）的乘积都在 32 位整数范围内。 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 进阶： 你可以在常数空间复杂度内完成这个题目吗？（ 出于
对空间复杂度分析的目的，输出数组不被视为额外空间。）
*/

 class L238Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        
        // 初始时output[i]代表i左侧的所有数的乘积，不包含nums[i]
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        
        // right代表i右侧的所有数的乘积，不包含nums[i]
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= right;     // output[i]最终的结果就是左右两侧乘积的积
            right *= nums[i];       // right表示右侧所有数的乘积
        }
        
        return output;
    }
} 