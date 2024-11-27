package com.sky.algorithmleetcode;

/*
还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要
用到。 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。 示例 1:  输入: [1,1,2,2,2] 输出: true
 解释: 能拼成一个边长为2的正方形，每边两根火柴。  示例 2:  输入: [3,3,3,3,4] 输出: false 解释: 不能用所有火柴拼成一个正方形。
  注意:  	给定的火柴长度和在 0 到 10^9之间。 	火柴数组的长度不超过15。
*/

 class L473Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) return false;
        Arrays.sort(nums);
        int target = sum / 4;
        if (nums[nums.length - 1] > target) return false;
        int[] sums = new int[4];
        return dfs(nums, sums, 0, target);
    }

    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target;
        }
        int num = nums[index];
        for (int i = 0; i < 4; i++) {
            if (sums[i] + num <= target) {
                sums[i] += num;
                if (dfs(nums, sums, index + 1, target)) return true;
                sums[i] -= num;
            }
        }
        return false;
    }
} 