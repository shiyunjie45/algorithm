package com.sky.algorithmleetcode;

/*
给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。 我们是这样定义一个非递减数列的： 对于数组中所有的 
i (1 array[i] 。   示例 1: 输入: nums = [4,2,3] 输出: true 解释: 你可以通过把第一个4变成1来使得它成为一个非递减
数列。  示例 2: 输入: nums = [4,2,1] 输出: false 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。    说明：  	1
 	- 10 ^ 5
*/

 class L665Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i = 1; i < nums.length && cnt < 2; i++) {
            if(nums[i] >= nums[i - 1]) continue;  // 递增时跳过
            cnt++;  // 遇到逆序对时计数器加1
            if(i - 2 >= 0 && nums[i - 2] > nums[i]) nums[i] = nums[i - 1];  // 修改nums[i]为nums[i-1]或nums[i-2]的值
            else nums[i - 1] = nums[i];  // 修改nums[i-1]为nums[i]的值
        }
        return cnt <= 1;
    }
} 