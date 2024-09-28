package com.sky.algorithmleetcode;

/*
在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。 注意: n 是正数且在32位整数范围内 (
 n 31)。 示例 1: 输入: 3 输出: 3  示例 2: 输入: 11 输出: 0 说明: 第11个数字在序列 1, 2, 3, 4, 5, 6, 7,
 8, 9, 10, 11, ... 里是0，它是10的一部分。
*/

 L400Solution {
    public int findNthDigit(int n) {
        int digit = 1;//数字的位数
        long start = 1;//当前位数区间的第一个数
        long count = 9;//当前位数区间内所有数字的位数之和
        while (n > count) {//如果不在当前位数区间内，进入下一个区间
            n -= count;
            digit++;//位数加1
            start *= 10;//第一个数乘以10
            count = 9 * start * digit;//更新区间内所有数字的位数之和
        }
        long num = start + (n - 1) / digit;//找到第n个字符所在的数字
        return Long.toString(num).charAt((n - 1) % digit) - '0';//找到第n个字符并返回
    }
} 