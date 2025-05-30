package com.sky.algorithmleetcode;

/*
给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。 重复出现的子串要计算它们出现的次数
。 示例 1 :  输入: "00110011" 输出: 6 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“00
11” 和 “01”。 请注意，一些重复出现的子串要计算它们出现的次数。 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。  示例
 2 :  输入: "10101" 输出: 4 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。  注意：  	s.l
ength 在1到50,000之间。 	s 只包含“0”或“1”字符。
*/

 class L696Solution {

    public int countBinarySubstrings(String s) {
        int count = 0;
        int index = 0;
        int prevLength = 0;
        int curLength = 1;
        while (index < s.length() - 1) {
            if (s.charAt(index) != s.charAt(index + 1)) {
                prevLength = curLength;
                curLength = 1;
                count++;
                for (int i = 1; i <= prevLength && index - i >= 0 && s.charAt(index - i) == s.charAt(index); i++) {
                    count++;
                }
            } else {
                curLength++;
            }
            index++;
        }
        return count;
    }

    public static void main(String[] args) {
        L696Solution solution = new L696Solution();
        String s1 = "00110011";
        String s2 = "10101";
        System.out.println(solution.countBinarySubstrings(s1)); // output: 6
        System.out.println(solution.countBinarySubstrings(s2)); // output: 4
    }
} 