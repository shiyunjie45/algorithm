package com.sky.algorithmleetcode;

/*
在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。   示例： 输入：A = [1,0,1,0,1], S = 2 输出：4 解释： 
如下面黑体所示，有 4 个满足题目要求的子数组： [1,0,1,0,1] [1,0,1,0,1] [1,0,1,0,1] [1,0,1,0,1]    提示： 
 	A.length 	0 	A[i] 为 0 或 1
*/

 java.util.HashMap;

public class L930Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int n = A.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        int ans = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int targetSum = prefixSum[i] - S;
            if (freq.containsKey(targetSum)) {
                ans += freq.get(targetSum);
            }
            freq.put(prefixSum[i], freq.getOrDefault(prefixSum[i], 0) + 1);
        }
        return ans;
    }
} 