package com.sky.algorithmleetcode;

/*
给定一个整数数组 nums ，你可以对它进行一些操作。 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等
于 nums[i] - 1 或 nums[i] + 1 的元素。 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 示例 1:  输入: nums 
= [3, 4, 2] 输出: 6 解释: 删除 4 来获得 4 个点数，因此 3 也被删除。 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。  示
例 2:  输入: nums = [2, 2, 3, 3, 3, 4] 输出: 9 解释: 删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。 之后，
再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。 总共获得 9 个点数。  注意:  	nums的长度最大为20000。 	每个整数nums[i
]的大小都在[1, 10000]范围内。
*/

 java.util.Arrays;

public class L740Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for(int num: nums){
            count[num]++;
        }
        int[] dp = new int[10001];
        dp[1] = count[1];
        dp[2] = Math.max(dp[1], count[2] * 2);
        for(int i = 3; i <= 10000; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + count[i] * i);
        }
        return dp[10000];
    }

    public static void main(String[] args) {
        L740Solution solution = new L740Solution();
        int[] nums1 = {3, 4, 2};
        int[] nums2 = {2, 2, 3, 3, 3, 4};
        System.out.println("Case 1: " + solution.deleteAndEarn(nums1));
        System.out.println("Case 2: " + solution.deleteAndEarn(nums2));
    }
} 