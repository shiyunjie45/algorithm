package com.sky.algorithmleetcode;

/*
给定两个字符串 s 和 t，它们只包含小写字母。 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 请找出在 t 中被添加的字母。   示例: 
输入： s = "abcd" t = "abcde" 输出： e 解释： 'e' 是那个被添加的字母。
*/

 class L389Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        // 统计字符串s中每个字符出现的次数
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        // 遍历字符串t中的字符并在count数组中减去
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            // 当出现负数时说明该字符是被添加的字符
            if (count[c - 'a'] < 0) {
                return c;
            }
        }
        return ' ';
    }
} 