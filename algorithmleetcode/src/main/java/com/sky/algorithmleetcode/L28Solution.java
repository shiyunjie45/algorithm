package com.sky.algorithmleetcode;

/*
实现 strStr() 函数。 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第
一个位置 (从0开始)。如果不存在，则返回  -1。 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2  示例
 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1  说明: 当 needle 是空字符串时，我们应当返回什么值
呢？这是一个在面试中很好的问题。 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexO
f() 定义相符。
*/

 class L28Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int n = haystack.length(), m = needle.length();
        if (n < m) {
            return -1;
        }
        for (int i = 0; i <= n - m; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
} 