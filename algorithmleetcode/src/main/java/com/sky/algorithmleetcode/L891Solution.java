package com.sky.algorithmleetcode;

/*
给定一个整数数组 A ，考虑 A 的所有非空子序列。 对于任意序列 S ，设 S 的宽度是 S 的最大元素和最小元素的差。 返回 A 的所有子序列的宽度之和。 
由于答案可能非常大，请返回答案模 10^9+7。   示例： 输入：[2,1,3] 输出：6 解释： 子序列为 [1]，[2]，[3]，[2,1]，[2,3]，
[1,3]，[2,1,3] 。 相应的宽度是 0，0，0，1，1，2，2 。 这些宽度之和是 6 。    提示：  	1 	1
*/

 class L891Solution {
    public static int sumSubseqWidths(int[] A) {
        int res = 0;
        Arrays.sort(A);
        int len = A.length, mod = 1000000007;
        long c = 1;
        for (int i = 0; i < len; i++, c = (c << 1) % mod) {
            res = (int) ((res + A[i] * c - A[len - i - 1] * c) % mod);
        }
        return (res + mod) % mod;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 3};
        System.out.println(sumSubseqWidths(A));
    }
} 