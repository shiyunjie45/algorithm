package com.sky.algorithmleetcode;

/*
给定一个正整数 n，你可以做如下操作： 1. 如果 n 是偶数，则用 n / 2替换 n。 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。 
n 变为 1 所需的最小替换次数是多少？ 示例 1:  输入: 8 输出: 3 解释: 8 -> 4 -> 2 -> 1  示例 2:  输入: 7 输出: 4
 解释: 7 -> 8 -> 4 -> 2 -> 1 或 7 -> 6 -> 3 -> 2 -> 1
*/

 class L397Solution {
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {// n为偶数
            return 1 + integerReplacement(n / 2);
        } else {// n为奇数
            long nn = n;
            return 2 + Math.min(integerReplacement((int) ((nn + 1) / 2)), integerReplacement((int) ((nn - 1) / 2)));
        }
    }
} 