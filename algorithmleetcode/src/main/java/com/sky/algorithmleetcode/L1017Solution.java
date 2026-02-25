package com.sky.algorithmleetcode;

/*
给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。 除非字符串就是 "0"，否则返回的字符串中不能含有
前导零。   示例 1： 输入：2 输出："110" 解释：(-2) ^ 2 + (-2) ^ 1 = 2  示例 2： 输入：3 输出："111" 解释：(-
2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3  示例 3： 输入：4 输出："100" 解释：(-2) ^ 2 = 4    提示：  	0
*/

public class L1017Solution {
    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            int remainder = N % (-2);
            N /= (-2);
            if (remainder < 0) {
                remainder += 2;
                N += 1;
            }
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }
} 