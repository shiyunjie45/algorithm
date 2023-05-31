package com.sky.algorithmleetcode;

/*
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 示例 1: 输入: "(()" 输出: 2 解释: 最长有效括号子串为 "(
)"  示例 2: 输入: ")()())" 输出: 4 解释: 最长有效括号子串为 "()()"
*/

 class L32Solution {
    public static int longestValidParentheses(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }
} 