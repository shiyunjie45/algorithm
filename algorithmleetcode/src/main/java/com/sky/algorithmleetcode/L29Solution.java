package com.sky.algorithmleetcode;

/*
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 返回被除数 dividend 除以除数 d
ivisor 得到的商。 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.73
35) = -2   示例 1: 输入: dividend = 10, divisor = 3 输出: 3 解释: 10/3 = truncate(3.3333
3..) = truncate(3) = 3 示例 2: 输入: dividend = 7, divisor = -3 输出: -2 解释: 7/-3 = tr
uncate(-2.33333..) = -2   提示：  	被除数和除数均为 32 位有符号整数。 	除数不为 0。 	假设我们的环境只能存储 32 位有符
号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
*/

 class L29Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long dend = Math.abs((long) dividend);
        long sor = Math.abs((long) divisor);

        int res = 0;
        while (dend >= sor) {
            long temp = sor, multiple = 1;
            while (temp <= dend) {
                temp <<= 1;
                multiple <<= 1;
            }
            dend -= temp >> 1;
            res += multiple >> 1;
        }

        return positive ? res : -res;
    }
} 