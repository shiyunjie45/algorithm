package com.sky.algorithmleetcode;

/*
给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。 注意：1 ≤ k ≤ n ≤ 109。 示例 :  输入: n: 13  k: 2 输出: 
10 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
*/

 class L440Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1; // 从1开始
        k -= 1; // 先把k减1，因为cur已经是一
        while (k > 0) {
            long steps = 0; // 步长
            long first = cur;
            long last = cur + 1;
            while (first <= n) {
                steps += Math.min((long)n + 1, last) - first;
                first *= 10;
                last *= 10;
            }
            if (steps <= k) { // 继续向后移
                cur += 1;
                k -= steps;
            } else { // 走到下一层
                cur *= 10;
                k -= 1;
            }
        }
        return cur;
    }
} 