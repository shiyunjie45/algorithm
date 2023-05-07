package com.sky.algorithmleetcode;

/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假
定每组输入只存在唯一答案。 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1. 与 target 最接近的三个数的和为 2. (
-1 + 2 + 1 = 2).
*/

import java.util.Arrays;

public class L16Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
} 