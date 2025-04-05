package com.sky.algorithmleetcode;

/*
给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 示例 1 :  输入: 2736 输出: 7236 解释: 交换数字2和数字7。 
 示例 2 :  输入: 9973 输出: 9973 解释: 不需要交换。  注意:  	给定数字的范围是 [0, 108]
*/

 class L670Solution {
    public int maximumSwap(int num) {
        // 将 num 转换为字符数组
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;

        // 记录 0-9 出现的最后位置
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[digits[i] - '0'] = i;
        }

        // 从高位向低位寻找，如果存在更大的数，就进行交换
        for (int i = 0; i < n; i++) {
            for (int j = 9; j > (digits[i] - '0'); j--) {
                if (last[j] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[last[j]];
                    digits[last[j]] = tmp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        // 如果不存在更大的数，返回原数即可
        return num;
    }
} 