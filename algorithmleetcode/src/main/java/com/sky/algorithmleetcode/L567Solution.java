package com.sky.algorithmleetcode;

/*
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 换句话说，第一个字符串的排列之一是第二个字符串的子串。 示例1:  输入: s
1 = "ab" s2 = "eidbaooo" 输出: True 解释: s2 包含 s1 的排列之一 ("ba").    示例2:  输入: s1= "a
b" s2 = "eidboaoo" 输出: False    注意：  	输入的字符串只包含小写字母 	两个字符串的长度都在 [1, 10,000] 之间
*/

 java.util.Arrays;

class L567Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return false;
        }
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        for (int i = 0; i < len1; i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }
        for (int i = len1; i < len2; i++) {
            if (Arrays.equals(s1Freq, s2Freq)) {
                return true;
            }
            s2Freq[s2.charAt(i - len1) - 'a']--;
            s2Freq[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(s1Freq, s2Freq);
    }
} 