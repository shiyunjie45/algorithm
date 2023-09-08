package com.sky.algorithmleetcode;

/*
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子
。 说明：  	分隔时可以重复使用字典中的单词。 	你可以假设字典中没有重复的单词。  示例 1： 输入: s = "catsanddog" wordDict 
= ["cat", "cats", "and", "sand", "dog"] 输出: [   "cats and dog",   "cat sand dog"
 ]  示例 2： 输入: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen", "p
ine", "pineapple"] 输出: [   "pine apple pen apple",   "pineapple pen apple",   "p
ine applepen apple" ] 解释: 注意你可以重复使用字典中的单词。  示例 3： 输入: s = "catsandog" wordDict =
 ["cats", "dog", "sand", "and", "cat"] 输出: []
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class L140Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return wordBreakHelper(s, wordDict, map);
    }

    private List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new ArrayList<>();

        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = wordBreakHelper(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    if (sub.isEmpty()) {
                        res.add(word);
                    } else {
                        res.add(word + " " + sub);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
} 