package com.sky.algorithmleetcode;

/*
如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。 例如，以下数列为等差数列: 1, 3, 5, 7, 9 7, 7, 7, 7 
3, -1, -5, -9 以下数列不是等差数列。 1, 1, 2, 5, 7   数组 A 包含 N 个数，且索引从 0 开始。该数组子序列将划分为整数序列 
(P0, P1, ..., Pk)，P 与 Q 是整数且满足 0 ≤ P0 1 k    如果序列 A[P0]，A[P1]，...，A[Pk-1]，A[Pk] 
是等差的，那么数组 A 的子序列 (P0，P1，…，PK) 称为等差序列。值得注意的是，这意味着 k ≥ 2。 函数要返回数组 A 中所有等差子序列的个数。 输
入包含 N 个整数。每个整数都在 -231 和 231-1 之间，另外 0 ≤ N ≤ 1000。保证输出小于 231-1。   示例：   输入：[2, 4,
 6, 8, 10] 输出：7 解释： 所有的等差子序列为： [2,4,6] [4,6,8] [6,8,10] [2,4,6,8] [4,6,8,10] [2,
4,6,8,10] [2,6,10]
*/

 class L446Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int n = A.length;
        Map<Long, Integer>[] map = new Map[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - A[j];
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                int cnt = map[j].getOrDefault(diff, 0);
                res += cnt;
                map[i].put(diff, map[i].getOrDefault(diff, 0) + cnt + 1);
            }
        }
        return res;
    }
} 