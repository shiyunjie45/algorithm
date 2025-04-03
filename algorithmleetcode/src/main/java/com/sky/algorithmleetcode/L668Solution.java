package com.sky.algorithmleetcode;

/*
几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？ 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数
字。 例 1：  输入: m = 3, n = 3, k = 5 输出: 3 解释: 乘法表: 1	2	3 2	4	6 3	6	9 第5小的数字是 3 (1, 
2, 2, 3, 3).  例 2：  输入: m = 2, n = 3, k = 6 输出: 6 解释: 乘法表: 1	2	3 2	4	6 第6小的数字是 6
 (1, 2, 2, 3, 4, 6).  注意：  	m 和 n 的范围在 [1, 30000] 之间。 	k 的范围在 [1, m * n] 之间。
*/

 class L668Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (count(mid, m, n) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int count(int target, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(target / i, n);
        }
        return count;
    }
} 