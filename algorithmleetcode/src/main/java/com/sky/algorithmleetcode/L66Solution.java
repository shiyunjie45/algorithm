package com.sky.algorithmleetcode;

/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 你可以假设除了整数 0 之外，
这个整数不会以零开头。 示例 1: 输入: [1,2,3] 输出: [1,2,4] 解释: 输入数组表示数字 123。  示例 2: 输入: [4,3,2,1]
 输出: [4,3,2,2] 解释: 输入数组表示数字 4321。
*/

 class L66Solution {
    public int[] plusOne(int[] digits) {
        // 从最后一位开始遍历数组
        for (int i = digits.length - 1; i >= 0; i--) {
            // 当前位加1
            digits[i]++;
            // 模拟进位
            digits[i] %= 10;
            // 如果当前位没有进位，直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 如果最高位也进位了，数组长度需要加1
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
} 