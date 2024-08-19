package com.sky.algorithmleetcode;

/*
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 示例 1: 输入: "hello" 输出: "holle"  示例 2: 输入: "leetcode
" 输出: "leotcede" 说明: 元音字母不包含字母"y"。
*/

 class L345Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            while (start < end && !vowels.contains(chars[start])) {
                start++;
            }
            while (start < end && !vowels.contains(chars[end])) {
                end--;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }
} 