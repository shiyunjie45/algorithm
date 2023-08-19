package com.sky.algorithmleetcode;

/*
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 例如，给定三角形： [   [2],   [3,4],  [6,5,7],  
[4,1,8,3] ]  自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 说明： 如果你可以只使用 O(n) 的额外空间（n 为三角
形的总行数）来解决这个问题，那么你的算法会很加分。
*/

import java.util.List;

public class L120Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            List<Integer> curRow = triangle.get(i);
            for (int j = 0; j < curRow.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + curRow.get(j);
            }
        }
        return dp[0];
    }
} 