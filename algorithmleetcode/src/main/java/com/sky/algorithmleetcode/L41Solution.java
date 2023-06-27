package com.sky.algorithmleetcode;

/*
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。   示例 1: 输入: [1,2,0] 输出: 3  示例 2: 输入: [3,4,-1,1] 
输出: 2  示例 3: 输入: [7,8,9,11,12] 输出: 1    提示： 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
*/

 class L41Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 首先对数组进行一次遍历，将所有不在 [1, n] 中的数修改为其他数。
        // 因为 [1, n] 的最小未出现正整数为 n+1，所以这里将所有不在 [1, n] 中的数修改为 n+1，不影响最终结果。
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // 再次对数组进行遍历，对出现过的数对应的索引位置上的值取相反数，表示这个数出现过。
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // 最后再进行一次遍历，找到第一个未出现的正整数并返回。
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    } 
} 