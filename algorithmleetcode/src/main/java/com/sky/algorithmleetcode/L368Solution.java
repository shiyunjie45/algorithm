package com.sky.algorithmleetcode;

/*
给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。 如果
有多个目标子集，返回其中任何一个均可。   示例 1: 输入: [1,2,3] 输出: [1,2] (当然, [1,3] 也正确)  示例 2: 输入: [1,
2,4,8] 输出: [1,2,4,8]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L368Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<Integer>();

        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] pre = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);

        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (maxIndex != -1) {
            res.add(nums[maxIndex]);
            maxIndex = pre[maxIndex];
        }
        return res;
    }
} 