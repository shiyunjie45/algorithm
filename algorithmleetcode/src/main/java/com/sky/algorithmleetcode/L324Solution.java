package com.sky.algorithmleetcode;

/*
给定一个无序的数组 nums，将它重新排列成 nums[0] nums[2]  的顺序。 示例 1: 输入: nums = [1, 5, 1, 1, 6, 4]
 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6] 示例 2: 输入: nums = [1, 3, 2, 2, 3, 1] 输出: 一个可能的答案
是 [2, 3, 1, 3, 1, 2] 说明: 你可以假设所有输入都会得到有效的结果。 进阶: 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间
来实现吗？
*/

import java.util.Arrays;

public class L324Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);//排序
        int n = nums.length;
        int[] temp = new int[n];
        int smallIndex = n % 2 == 0 ? n / 2 - 1 : n / 2;
        int largeIndex = n - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                temp[i] = nums[smallIndex--];
            } else {
                temp[i] = nums[largeIndex--];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
} 