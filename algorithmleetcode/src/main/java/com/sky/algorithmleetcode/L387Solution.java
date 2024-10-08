package com.sky.algorithmleetcode;

/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 案例:  s = "leetcode" 返回 0. s = "lovel
eetcode", 返回 2.    注意事项：您可以假定该字符串只包含小写字母。
*/

 class L387Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26]; // 计数数组
        // 第一次遍历，用计数数组统计每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // 第二次遍历，找到第一个只出现一次的字符并返回其索引
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1; // 如果没有找到则返回 -1
    }
} 