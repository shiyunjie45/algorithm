package com.sky.algorithmleetcode;

/*
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 注意子串要与 words 中的单
词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。   示例 1： 输入：  s = "barfoothefoobarman",  w
ords = ["foo","bar"] 输出：[0,9] 解释： 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。 输出的顺序
不重要, [9,0] 也是有效答案。  示例 2： 输入：  s = "wordgoodgoodgoodbestword",  words = ["word",
"good","best","word"] 输出：[]
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L30Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return res;

        Map<String, Integer> map = new HashMap<>(); // 用于记录每个单词出现的次数
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int totalWords = words.length;
        int sLen = s.length();

        for (int i = 0; i <= sLen - wordLen * totalWords; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            int j = i;
            while (j < i + wordLen * totalWords) {
                String word = s.substring(j, j + wordLen);
                if (!copy.containsKey(word) || copy.get(word) < 1) {
                    break;
                }
                copy.put(word, copy.get(word) - 1);
                j += wordLen;
            }

            if (j == i + wordLen * totalWords) {
                res.add(i);
            }
        }

        return res;
    }
} 