package com.sky.algorithmleetcode;

/*
给定范围 [m, n]，其中 0  示例 1:  输入: [5,7] 输出: 4 示例 2: 输入: [0,1] 输出: 0
*/

 class L201Solution {

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }

    public static void main(String[] args) {
        L201Solution solution = new L201Solution();
        System.out.println(solution.rangeBitwiseAnd(5, 7)); // 输出 4
        System.out.println(solution.rangeBitwiseAnd(0, 1)); // 输出 0
    }
} 