package com.sky.algorithmleetcode;

/*
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。 示例: 输入: 38 输出: 2 解释: 各位相加的过程为：3 + 8 = 11, 1 
+ 1 = 2。 由于 2 是一位数，所以返回 2。  进阶: 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
*/

 class L258Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int temp = 0;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }
        return num;
    }
} 