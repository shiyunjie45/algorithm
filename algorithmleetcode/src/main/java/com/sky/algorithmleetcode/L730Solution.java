package com.sky.algorithmleetcode;

/*
给定一个字符串 S，找出 S 中不同的非空回文子序列个数，并返回该数字与 10^9 + 7 的模。 通过从 S 中删除 0 个或多个字符来获得子字符序列。 如果
一个字符序列与它反转后的字符序列一致，那么它是回文字符序列。 如果对于某个  i，A_i != B_i，那么 A_1, A_2, ... 和 B_1, B_2,
 ... 这两个字符序列是不同的。   示例 1： 输入： S = 'bccb' 输出：6 解释： 6 个不同的非空回文子字符序列分别为：'b', 'c', '
bb', 'cc', 'bcb', 'bccb'。 注意：'bcb' 虽然出现两次但仅计数一次。  示例 2： 输入： S = 'abcdabcdabcdabc
dabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba' 输出：104860361 解释： 共有 310486038
2 个不同的非空回文子字符序列，对 10^9 + 7 取模为 104860361。    提示：  	字符串 S 的长度将在[1, 1000]范围内。 	每个字
符 S[i] 将会是集合 {'a', 'b', 'c', 'd'} 中的某一个。
*/

 class L730Solution {
    public static int countPalindromicSubsequences(String S) {
        int n = S.length();
        int MOD = 1000000007;
        int[][][] dp = new int[n][n][4];
        // dp数组的含义是dp[left][right][k]表示在left和right之间，字符为k的不同非空回文子序列个数
        // 其中k=0表示a，k=1表示b，k=2表示c，k=3表示d
        // 初始化dp数组，对角线处的dp值为1（一个单独的字符也是一个回文子序列）
        for (int i = 0; i < n; i++) {
            dp[i][i][S.charAt(i) - 'a'] = 1;
        }
        // 枚举区间长度
        for (int len = 2; len <= n; len++) {
            // 枚举左端点
            for (int left = 0; left <= n - len; left++) {
                // 计算右端点
                int right = left + len - 1;
                // 枚举字符
                for (int k = 0; k < 4; k++) {
                    // 如果left和right位置上的字符不相同，直接跳过
                    if (S.charAt(left) - 'a' != k) {
                        dp[left][right][k] = dp[left + 1][right][k];
                        continue;
                    }
                    if (S.charAt(right) - 'a' != k) {
                        dp[left][right][k] = dp[left][right - 1][k];
                        continue;
                    }
                    // 如果left和right位置上的字符相同，那么就有四种情况，分别是：
                    // 1. 两个字符都不取，回文子序列的数目等于[left+1, right-1]区间内所有回文子序列的数目
                    // 2. 只取左边的字符，回文子序列数目等于[left+1, right]区间内所有回文子序列的数目 + 1
                    // 3. 只取右边的字符，回文子序列数目等于[left, right-1]区间内所有回文子序列的数目 + 1
                    // 4. 两个字符都取，回文子序列数目等于[left+1, right-1]区间内所有回文子序列的数目 + 2
                    dp[left][right][k] = 2;
                    for (int m = 0; m < 4; m++) {
                        dp[left][right][k] += dp[left + 1][right - 1][m];
                        dp[left][right][k] %= MOD;
                    }
                    if (left + 1 <= right - 1) {
                        dp[left][right][k] -= dp[left + 1][right - 1][k];
                    }
                    dp[left][right][k] %= MOD;
                    dp[left][right][k] += MOD;
                    dp[left][right][k] %= MOD;
                    dp[left][right][k] += dp[left + 1][right][k];
                    dp[left][right][k] %= MOD;
                    dp[left][right][k] += dp[left][right - 1][k];
                    dp[left][right][k] %= MOD;
                }
            }
        }
        int ans = 0;
        for (int k = 0; k < 4; k++) {
            ans += dp[0][n - 1][k];
            ans %= MOD;
        }
        return ans;
    }
} 