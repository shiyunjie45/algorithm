package com.sky.algorithmleetcode;

/*
给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x n 。 示例: 输入: 2 输出: 91 解释: 答案应为除去 11,22,33,
44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
*/

 class L357Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 10;
        int uniqueDigits = 9;
        int availableNumbers = 9;
        while (n-- > 1 && availableNumbers > 0) {
            uniqueDigits = uniqueDigits * availableNumbers;
            res += uniqueDigits;
            availableNumbers--;
        }
        return res;
    }
} 