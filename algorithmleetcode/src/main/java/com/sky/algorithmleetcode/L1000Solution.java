package com.sky.algorithmleetcode;

/*
有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的
总数。 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。   示例 1： 输入：stones = [3,2,4,1], K = 2 输出：20 解
释： 从 [3, 2, 4, 1] 开始。 合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。 合并 [4, 1]，成本为 5，剩下 [5, 5]。 合
并 [5, 5]，成本为 10，剩下 [10]。 总成本 20，这是可能的最小值。  示例 2： 输入：stones = [3,2,4,1], K = 3 输出
：-1 解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.  示例 3： 输入：stones = [3,5,1,2,6]
, K = 3 输出：25 解释： 从 [3, 5, 1, 2, 6] 开始。 合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。 合并 [3, 
8, 6]，成本为 17，剩下 [17]。 总成本 25，这是可能的最小值。    提示：  	1 	2 	1
*/

import java.util.*;

public class L1000Solution {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) {
            return -1;
        }
        int[][] dp = new int[n][n];
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        for (int len = K; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int p = i; p < j; p += K - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][p] + dp[p + 1][j]);
                }
                if ((len - 1) % (K - 1) == 0) {
                    dp[i][j] += sum[j + 1] - sum[i];
                }
            }
        }
        return dp[0][n - 1];
    }
} 