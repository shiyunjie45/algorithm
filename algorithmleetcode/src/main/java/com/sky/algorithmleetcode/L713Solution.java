package com.sky.algorithmleetcode;

/*
给定一个正整数数组 nums。 找出该数组内乘积小于 k 的连续的子数组的个数。 示例 1:  输入: nums = [10,5,2,6], k = 100 输
出: 8 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。 需
要注意的是 [10,5,2] 并不是乘积小于100的子数组。  说明:  	0 	0 	0
*/

 class L713Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0; // 定义双指针
        int product = 1; // 初始化积为1
        int count = 0; // 记录子数组的个数
        while (right < n) {
            product *= nums[right]; // 右指针向右移动，更新积
            while (left <= right && product >= k) {
                product /= nums[left++]; // 积超过k，则左指针向右移动，更新积
            }
            count += (right - left + 1); // 新增的子数组个数即为右指针到左指针的距离加1
            right++; // 右指针向右移动
        }
        return count;
    }
} 