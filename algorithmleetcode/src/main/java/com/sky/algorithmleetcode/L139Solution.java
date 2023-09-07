package com.sky.algorithmleetcode;

/*
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 说明：  	拆分时可以重复
使用字典中的单词。 	你可以假设字典中没有重复的单词。  示例 1： 输入: s = "leetcode", wordDict = ["leet", "code
"] 输出: true 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。  示例 2： 输入: s = "applep
enapple", wordDict = ["apple", "pen"] 输出: true 解释: 返回 true 因为 "applepenapple" 可以
被拆分成 "apple pen apple"。    注意你可以重复使用字典中的单词。  示例 3： 输入: s = "catsandog", wordDict
 = ["cats", "dog", "sand", "and", "cat"] 输出: false
*/

import java.util.*;

public class L139Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;
        if (wordDict == null || wordDict.size() == 0)
            return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String word = s.substring(j, i + 1);
                if (wordDict.contains(word) && dp[j]) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
} 