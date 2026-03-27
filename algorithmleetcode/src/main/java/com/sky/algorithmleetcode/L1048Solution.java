package com.sky.algorithmleetcode;

/*
给出一个单词列表，其中每个单词都由小写英文字母组成。 如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 wo
rd2 的前身。例如，"abc" 是 "abac" 的前身。 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，
其中 word_1 是 word_2 的前身，word_2 是 word_3 的前身，依此类推。 从给定单词列表 words 中选择单词组成词链，返回词链的最长
可能长度。   示例： 输入：["a","b","ba","bca","bda","bdca"] 输出：4 解释：最长单词链之一为 "a","ba","bda"
,"bdca"。    提示：  	1 	1 	words[i] 仅由小写英文字母组成。
*/

 java.util.Arrays;

public class L1048Solution {

    public int longestStrChain(String[] words) {
        int n = words.length;
        if (n == 0 || n == 1) {
            return n;
        }

        // 按长度从小到大排序
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        // dp[i]表示以words[i]为终点的最长链长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (words[i].length() - words[j].length() > 1) {
                    break;
                }
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    // 判断str1是否是str2的前身
    private boolean isPredecessor(String str1, String str2) {
        if (str1.length() + 1 != str2.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == str1.length();
    }
} 