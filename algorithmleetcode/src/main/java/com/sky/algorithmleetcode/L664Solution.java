package com.sky.algorithmleetcode;

/*
有台奇怪的打印机有以下两个特殊要求：  	打印机每次只能打印同一个字符序列。 	每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。  给定一个
只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。 示例 1:  输入: "aaabbb" 输出: 2 解释: 首先打印 "aaa" 然
后打印 "bbb"。  示例 2:  输入: "aba" 输出: 2 解释: 首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。 提
示: 输入字符串的长度不会超过 100。
*/

 class L664Solution {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        int[][] dp = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        
        for (int k = 2; k <= len; k++) {
            for (int i = 0; i <= len - k; i++) {
                int j = i + k - 1;
                dp[i][j] = dp[i+1][j] + 1;
                for (int p = i + 1; p <= j; p++) {
                    if (s.charAt(p) == s.charAt(i)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][p-1] + dp[p+1][j]);
                    }
                }
            }
        }
        
        return dp[0][len-1];
    }
} 