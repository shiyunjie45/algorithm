package com.sky.algorithmleetcode;

/*
实现 int sqrt(int x) 函数。 计算并返回 x 的平方根，其中 x 是非负整数。 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 示
例 1: 输入: 4 输出: 2  示例 2: 输入: 8 输出: 2 说明: 8 的平方根是 2.82842...,    由于返回类型是整数，小数部分将被舍
去。
*/

 class L69Solution {
    public int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
} 