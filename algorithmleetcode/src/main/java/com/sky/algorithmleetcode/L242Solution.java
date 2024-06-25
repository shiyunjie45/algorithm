package com.sky.algorithmleetcode;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 示例 1: 输入: s = "anagram", t = "nagaram" 
输出: true  示例 2: 输入: s = "rat", t = "car" 输出: false 说明: 你可以假设字符串只包含小写字母。 进阶: 如果输入
字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
*/

 class L242Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26]; //字母表中26个小写字母出现的频率，下标对应字母ascii码减去97
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) { //如果所有字母出现的频率都一样，则count数组应该全为0
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
} 