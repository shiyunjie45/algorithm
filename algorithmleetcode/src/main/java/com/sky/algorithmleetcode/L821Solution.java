package com.sky.algorithmleetcode;

/*
给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。 示例 1:  输入: S = "lovel
eetcode", C = 'e' 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]  说明:  	字符串 S 的长度范围为 [
1, 10000]。 	C 是一个单字符，且保证是字符串 S 里的字符。 	S 和 C 中的所有字母均为小写字母。
*/

 class L821Solution {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        int prev = -S.length();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) prev = i;
            res[i] = i - prev;
        }
        prev = 2 * S.length();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) prev = i;
            res[i] = Math.min(res[i], prev - i);
        }
        return res;
    }
} 