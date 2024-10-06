package com.sky.algorithmleetcode;

/*
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 注意:
 假设字符串的长度不会超过 1010。 示例 1:  输入: "abccccdd" 输出: 7 解释: 我们可以构造的最长的回文串是"dccaccd", 它的长
度是 7。
*/

 class L409Solution {
    public int longestPalindrome(String s) {
        int[] charCount = new int[128]; // 用于记录各个字符出现的次数
        for (char c : s.toCharArray()) {
            charCount[c]++;
        }
        int length = 0;
        for (int count : charCount) {
            length += (count / 2) * 2; // 对于每个字符出现的次数，取其偶数部分
            if (count % 2 == 1 && length % 2 == 0) {
                length++; // 如果此字符出现了奇数次且构成回文串长度为偶数，则将其加入回文串中
            }
        }
        return length;
    }
} 