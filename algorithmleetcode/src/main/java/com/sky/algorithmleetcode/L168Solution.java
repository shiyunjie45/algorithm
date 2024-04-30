package com.sky.algorithmleetcode;

/*
给定一个正整数，返回它在 Excel 表中相对应的列名称。 例如，   1 -> A   2 -> B   3 -> C   ...   26 -> Z   2
7 -> AA   28 -> AB   ...  示例 1: 输入: 1 输出: "A"  示例 2: 输入: 28 输出: "AB"  示例 3: 输入: 
701 输出: "ZY"
*/

 class L168Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int remainder = n % 26;
            n /= 26;
            sb.insert(0, (char) ('A' + remainder));
        }
        return sb.toString();
    }
} 