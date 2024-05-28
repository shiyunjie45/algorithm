package com.sky.algorithmleetcode;

/*
给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 示例 1: 输入: "aacecaaa" 输出:
 "aaacecaaa"  示例 2: 输入: "abcd" 输出: "dcbabcd"
*/

 class L214Solution {
    public static String shortestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int endIndex = len - 1;
        //找到最大的回文串
        while (endIndex > 0) {
            if (isPalindrome(s, endIndex)) {
                break;
            }
            endIndex--;
        }
        StringBuilder sb = new StringBuilder(s.substring(endIndex + 1, len));
        //将回文串前面的字符串倒叙拼接到sb
        for (int i = endIndex; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private static boolean isPalindrome(String s, int endIndex) {
        int start = 0;
        while (start < endIndex) {
            if (s.charAt(start++) != s.charAt(endIndex--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abcd"));
    }
} 