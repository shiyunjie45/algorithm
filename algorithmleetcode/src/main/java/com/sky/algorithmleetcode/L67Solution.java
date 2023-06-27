package com.sky.algorithmleetcode;

/*
给你两个二进制字符串，返回它们的和（用二进制表示）。 输入为 非空 字符串且只包含数字 1 和 0。   示例 1: 输入: a = "11", b = "1"
 输出: "100" 示例 2: 输入: a = "1010", b = "1011" 输出: "10101"   提示：  	每个字符串仅由字符 '0' 或 
'1' 组成。 	1 	字符串如果不是 "0" ，就都不含前导零。
*/

 class L67Solution {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;  // 进位标志

        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
} 