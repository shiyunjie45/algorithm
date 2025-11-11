package com.sky.algorithmleetcode;

/*
给你一个整数数组 nums，请你将该数组升序排列。     示例 1： 输入：nums = [5,2,3,1] 输出：[1,2,3,5]  示例 2： 输入：n
ums = [5,1,1,2,0,0] 输出：[0,0,1,1,2,5]    提示：  	1 	-50000
*/

 class L912Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean swap = false;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} 