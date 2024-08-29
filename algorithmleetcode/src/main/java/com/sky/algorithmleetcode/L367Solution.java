package com.sky.algorithmleetcode;

/*
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 说明：不要使用任何内置的库函数，如  sqrt。
 示例 1： 输入：16 输出：True 示例 2： 输入：14 输出：False
*/

 class L367Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long left = 0;
        long right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            long midSquare = mid * mid;
            if (midSquare == num) {
                return true;
            } else if (midSquare > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
} 