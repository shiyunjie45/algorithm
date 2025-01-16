package com.sky.algorithmleetcode;

/*
给定两个表示复数的字符串。 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。 示例 1:  输入: "1+1i", "1+1i" 输出: "0+2i
" 解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。  示例 2:  输入: "1
+-1i", "1+-1i" 输出: "0+-2i" 解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换
为 0+-2i 的形式。  注意:  	输入字符串不包含额外的空格。 	输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 1
00] 之间。输出也应当符合这种形式。
*/

 class L537Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] arr1 = parseNum(num1); // 解析 num1
        int[] arr2 = parseNum(num2); // 解析 num2
        int a = arr1[0], b = arr1[1], c = arr2[0], d = arr2[1];
        int realPart = a * c - b * d; // 计算实部
        int imaginaryPart = a * d + b * c; // 计算虚部
        String res = realPart + "+" + imaginaryPart + "i"; // 拼接结果字符串
        return res;
    }
    
    /**
     * 解析复数字符串，将实部和虚部分别保存到数组中返回
     * @param num 复数字符串，形如 "3+4i"
     * @return 包含实部和虚部的数组
     */
    private int[] parseNum(String num) {
        String[] parts = num.split("\\+|i");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        int[] res = new int[]{a, b};
        return res;
    }
} 