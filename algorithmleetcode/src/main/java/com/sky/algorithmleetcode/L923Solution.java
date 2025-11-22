package com.sky.algorithmleetcode;

/*
给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i 且 A[i] + A[j] + A[k] == target 的元组 i, j, k
 的数量。 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。   示例 1： 输入：A = [1,1,2,2,3,3,4,4,5,5], targ
et = 8 输出：20 解释： 按值枚举（A[i]，A[j]，A[k]）： (1, 2, 5) 出现 8 次； (1, 3, 4) 出现 8 次； (2, 2
, 4) 出现 2 次； (2, 3, 3) 出现 2 次。  示例 2： 输入：A = [1,1,2,2,2,2], target = 5 输出：12 解释：
 A[i] = 1，A[j] = A[k] = 2 出现 12 次： 我们从 [1,1] 中选择一个 1，有 2 种情况， 从 [2,2,2,2] 中选出两个 
2，有 6 种情况。    提示：  	3 	0 	0
*/

 class L923Solution {
    public int threeSumMulti(int[] A, int target) {
        int MOD = 1000000007;
        long[] count = new long[101];
        for (int num : A) {
            count[num]++;
        }
        long res = 0;
        for (int i = 0; i <= 100; i++) {//i<=100因为题目说了A[i]<=100
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k >= 0 && k <= 100) {
                    if (i == j && j == k) {
                        res += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                    } else if (i == j && j != k) {
                        res += count[i] * (count[i] - 1) / 2 * count[k];
                    } else if (i < j && j < k) {
                        res += count[i] * count[j] * count[k];
                    }
                    res %= MOD;
                }
            }
        }
        return (int) res;
    }
} 