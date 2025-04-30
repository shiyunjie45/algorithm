package com.sky.algorithmleetcode;

/*
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 示例 1：  输入： nums = [4, 3, 
2, 3, 5, 2, 1], k = 4 输出： True 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。   注意:
  	1 	0
*/

 java.util.Arrays;

public class L698Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum(); // 计算数组总和
        if (sum % k != 0) {
            // 如果总和不能被分成k个相等的子集，则返回false
            return false;
        }
        int target = sum / k; // 每个子集需要的目标和
        Arrays.sort(nums); // 先对数组进行排序，方便后续的回溯算法
        int n = nums.length;
        // 如果最大的数已经大于目标和，那么一定不能分成k个子集，直接返回false
        if (nums[n - 1] > target) {
            return false;
        }
        boolean[] used = new boolean[n]; // 记录哪些数已经被使用过
        return dfs(nums, k, 0, n - 1, target, used);
    }

    private boolean dfs(int[] nums, int k, int curSum, int start, int target, boolean[] used) {
        if (k == 0) {
            return true; // 已经分成了k个子集，返回true
        }
        if (curSum == target) {
            return dfs(nums, k - 1, 0, nums.length - 1, target, used); // 继续构造下一个子集
        }
        for (int i = start; i >= 0; i--) {
            if (!used[i] && curSum + nums[i] <= target) {
                used[i] = true;
                if (dfs(nums, k, curSum + nums[i], i - 1, target, used)) {
                    return true; // 找到了一种划分方案，跳出循环并返回true
                }
                used[i] = false; // 回溯
            }
        }
        return false; // 没有找到合法的方案
    }
} 