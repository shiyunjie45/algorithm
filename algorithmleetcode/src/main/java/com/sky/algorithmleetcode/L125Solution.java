package com.sky.algorithmleetcode;

/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。 示例 1: 输入: "A m
an, a plan, a canal: Panama" 输出: true  示例 2: 输入: "race a car" 输出: false
*/

 class L125Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isAlphaNumeric(s.charAt(i))) {
                i++;
            }
            while (i < j && !isAlphaNumeric(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char ch) {
        return Character.isDigit(ch) || Character.isLetter(ch);
    }
} 