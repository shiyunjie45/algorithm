package com.sky.algorithmleetcode;

/*
给定一个整数，将其转化为7进制，并以字符串形式输出。 示例 1:  输入: 100 输出: "202"  示例 2:  输入: -7 输出: "-10"  注意
: 输入范围是 [-1e7, 1e7] 。
*/

 class L504Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0"; // 特判
        StringBuilder res = new StringBuilder();
        boolean negative = num < 0;
        if (negative) num = -num; // 转换成正数
        while (num > 0) {
            int remainder = num % 7;
            res.append(remainder);
            num /= 7;
        }
        if (negative) res.append("-"); // 加上负号
        return res.reverse().toString();
    }
} 