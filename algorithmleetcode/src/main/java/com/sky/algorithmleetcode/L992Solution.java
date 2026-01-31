package com.sky.algorithmleetcode;

/*
给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。 （例如，[1,2,3,1,2] 
中有 3 个不同的整数：1，2，以及 3。） 返回 A 中好子数组的数目。   示例 1： 输入：A = [1,2,1,2,3], K = 2 输出：7 解释：
恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].  示例 2
： 输入：A = [1,2,1,3,4], K = 3 输出：3 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4
].    提示：  	1 	1 	1
*/

 L992Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int n = A.length;
        int[] freq = new int[n+1];
        int l = 0, r = 0;
        int cnt = 0;
        int res = 0;
        while (r < n) {
            if (freq[A[r]] == 0) {
                cnt++;
            }
            freq[A[r]]++;
            while (cnt > K) {
                freq[A[l]]--;
                if (freq[A[l]] == 0) {
                    cnt--;
                }
                l++;
            }
            int tmp = l;
            while (cnt == K) {
                res++;
                freq[A[tmp]]--;
                if (freq[A[tmp]] == 0) {
                    cnt--;
                }
                tmp++;
            }
            r++;
        }
        return res;
    }
} 