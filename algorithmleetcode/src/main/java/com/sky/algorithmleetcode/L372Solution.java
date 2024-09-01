package com.sky.algorithmleetcode;

/*
你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。 示例 1: 输入: a = 2, b = [3] 输出
: 8  示例 2: 输入: a = 2, b = [1,0] 输出: 1024
*/

 class L372Solution {
    public int superPow(int a, int[] b) {
        int result = 1;
        a = a % 1337;  // 取模，加快运算
        for (int i = b.length - 1; i >= 0; i--) {
            int digit = b[i];
            int temp = a;
            for (int j = 1; j < digit; j++) {
                a = (a * temp) % 1337; // 次方计算
            }
            int pow = (int) Math.pow(10, b.length - 1 - i); // 计算当前位的次方
            result = (int) ((result * Math.pow(a, pow)) % 1337); // 最终结果
            a = temp;
        }
        return result;
    }
} 