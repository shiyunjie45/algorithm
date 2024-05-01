package com.sky.algorithmleetcode;

/*
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 你可以假设数组是非空的，并且给定的数组总是存在多数元
素。   示例 1: 输入: [3,2,3] 输出: 3 示例 2: 输入: [2,2,1,1,1,2,2] 输出: 2
*/

 class L169Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += (nums[i] == candidate) ? 1 : -1;
        }
        return candidate;
    }
} 