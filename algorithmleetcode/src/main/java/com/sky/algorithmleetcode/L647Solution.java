package com.sky.algorithmleetcode;

/*
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 示例 1:  
输入: "abc" 输出: 3 解释: 三个回文子串: "a", "b", "c".  示例 2:  输入: "aaa" 输出: 6 说明: 6个回文子串: "
a", "a", "a", "aa", "aa", "aaa".  注意:  	输入的字符串长度不会超过1000。
*/

 class L647Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countSubstrings(s, i, i); // 回文子串长度为奇数
            count += countSubstrings(s, i, i + 1); // 回文子串长度为偶数
        }
        return count;
    }

    private int countSubstrings(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
} 