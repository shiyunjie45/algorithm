package com.sky.algorithmleetcode;

/*
给出非负整数数组 A ，返回两个非重叠（连续）子数组中元素的最大和，子数组的长度分别为 L 和 M。（这里需要澄清的是，长为 L 的子数组可以出现在长为 M 的
子数组之前或之后。） 从形式上看，返回最大的 V，而 V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1]
 + ... + A[j+M-1]) 并满足下列条件之一：    	0 , 或 	0 .    示例 1： 输入：A = [0,6,5,2,2,5,1,9,4]
, L = 1, M = 2 输出：20 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。  示例 2： 输入：A = [3,8,1,3,
2,1,8,9,0], L = 3, M = 2 输出：29 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。  示例 3： 输入
：A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3 输出：31 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3
,8] 长度为 3。   提示：  	L >= 1 	M >= 1 	L + M 	0
*/

 class L1031Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        
        int res = 0;
        for (int i = L; i <= n; i++) {
            int maxL = getMax(preSum, 0, i - L, M);
            int maxR = getMax(preSum, i, n - L, M);
            res = Math.max(res, maxL + maxR);
        }
        return res;
    }
    
    private int getMax(int[] preSum, int start, int end, int len) {
        int curSum = preSum[start + len] - preSum[start];
        int res = curSum;
        for (int i = start + len; i < end; i++) {
            curSum += preSum[i + 1] - preSum[i - len + 1];
            res = Math.max(res, curSum);
        }
        return res;
    }
} 