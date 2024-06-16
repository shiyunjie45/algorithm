package com.sky.algorithmleetcode;

/*
给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 示例: 输入: 13 输出: 6 解释: 数字 1 出现在以下数字中: 1, 10,
 11, 12, 13 。
*/

 class L233Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        if (n < 10) return 1;
        String str = Integer.toString(n);
        int high = str.charAt(0) - '0';
        int pow = (int) Math.pow(10, str.length() - 1);
        int last = n - high * pow;
        if (high == 1) {
            return countDigitOne(pow - 1) + countDigitOne(last) + last + 1;
        } else {
            return pow + high * countDigitOne(pow - 1) + countDigitOne(last);
        }
    }
} 