package com.sky.algorithmleetcode;

/*
给定一个Excel表格中的列名称，返回其相应的列序号。 例如，   A -> 1   B -> 2   C -> 3   ...   Z -> 26   AA 
-> 27   AB -> 28   ...  示例 1: 输入: "A" 输出: 1  示例 2: 输入: "AB" 输出: 28  示例 3: 输入: "Z
Y" 输出: 701 致谢： 特别感谢 @ts 添加此问题并创建所有测试用例。
*/

 class L171Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            result = result * 26 + num;
        }
        return result;
    }
} 