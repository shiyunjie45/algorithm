package com.sky.algorithmleetcode;

/*
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 示例 1:  输入: "aba" 输出: True  示例 2:  输入: "abca" 
输出: True 解释: 你可以删除c字符。  注意:  	字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
*/

 class L680Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 左右两个字符不相等，尝试删除一个字符继续比较
                return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    // 判断子串是否为回文串
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
} 