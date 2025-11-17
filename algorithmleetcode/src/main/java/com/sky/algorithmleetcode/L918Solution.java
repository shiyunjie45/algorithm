package com.sky.algorithmleetcode;

/*
给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0  时 C[
i] = A[i]，而当 i >= 0 时 C[i+A.length] = C[i]） 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于
子数组 C[i], C[i+1], ..., C[j]，不存在 i  其中 k1 % A.length = k2 % A.length）   示例 1： 输入：
[1,-2,3,-2] 输出：3 解释：从子数组 [3] 得到最大和 3  示例 2： 输入：[5,-3,5] 输出：10 解释：从子数组 [5,5] 得到最大
和 5 + 5 = 10  示例 3： 输入：[3,-1,2,-1] 输出：4 解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4 
 示例 4： 输入：[3,-2,2,-3] 输出：3 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3  示例 5： 输入：[-2,-3,-1
] 输出：-1 解释：从子数组 [-1] 得到最大和 -1    提示：  	-30000 	1
*/

public class L918Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n]; // prefix sum of nums
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        // Compute the maximum subarray sum ending at each position i
        int[] maxEndingHere = new int[n];
        int maxSoFar = nums[0];
        maxEndingHere[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxEndingHere[i] = Math.max(maxEndingHere[i - 1] + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere[i]);
        }
        // Compute the maximum subarray sum starting at each position i
        int[] maxStartingHere = new int[n];
        maxStartingHere[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxStartingHere[i] = Math.max(maxStartingHere[i + 1] + nums[i], nums[i]);
        }
        // Compute the maximum of circular subarray
        int maxCircular = nums[0];
        for (int i = 1; i < n; i++) {
            int leftSum = prefixSum[i - 1];
            int rightSum = prefixSum[n - 1] - prefixSum[i - 1];
            int circularSum = Math.max(0, rightSum) + Math.max(0, leftSum); // maximum circular sum ending at position i
            maxCircular = Math.max(maxCircular, circularSum);
        }
        return Math.max(maxSoFar, maxCircular);
    }
} 