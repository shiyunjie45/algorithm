package com.sky.algorithmleetcode;

/*
给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2
k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。 示例:  输入: s = "abcdefg", k = 2 输出: "bacdfe
g"  要求:  	该字符串只包含小写的英文字母。 	给定字符串的长度和 k 在[1, 10000]范围内。
*/

 class L541Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            int j = Math.min(i + k - 1, chars.length - 1);
            reverse(chars, i, j);
            i += 2*k;
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }
} 