package com.sky.algorithmleetcode;

/*
给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。 示例 1: 输入: 16 输出: true  示例 2: 输入: 5 输出:
 false 进阶： 你能不使用循环或者递归来完成本题吗？
*/

 class L342Solution {
    public boolean isPowerOfFour(int num) {
        // 先判断是否为2的幂次方
        if ((num & (num - 1)) != 0) {
            return false;
        }
        // 再判断是否能整除3
        return (num & 0x55555555) != 0;
    }
} 