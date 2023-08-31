package com.sky.algorithmleetcode;

/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 返回符合要求的最少分割次数。 示例: 输入: "aab" 输出: 1 解释: 进行一次分割就
可将 s 分割成 ["aa","b"] 这样两个回文子串。
*/

 class L132Solution {
    
    public int minCut(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len]; // 记录子串是否为回文
        int[] cut = new int[len]; // 记录最小分割次数
        
        for (int i = 0; i < len; i++) { // 初始化
            cut[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[j + 1][i - 1])) { // 子串是回文
                    dp[j][i] = true;
                    if (j == 0) { // 整个串是回文
                        cut[i] = 0;
                    } else {
                        cut[i] = Math.min(cut[i], cut[j - 1] + 1);
                    }
                }
            }
        }
        return cut[len - 1];
    }
} 