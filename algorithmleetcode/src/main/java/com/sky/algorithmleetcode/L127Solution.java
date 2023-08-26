package com.sky.algorithmleetcode;

/*
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：  
	每次转换只能改变一个字母。 	转换过程中的中间单词必须是字典中的单词。  说明:  	如果不存在这样的转换序列，返回 0。 	所有单词具有相同的长度。 	所有
单词只由小写字母组成。 	字典中不存在重复的单词。 	你可以假设 beginWord 和 endWord 是非空的，且二者不相同。  示例 1: 输入: beg
inWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"
] 输出: 5 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",   返回它的长度 5。  示例
 2: 输入: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","dog","lot","l
og"] 输出: 0 解释: endWord "cog" 不在字典中，所以无法进行转换。
*/

import java.util.*;

public class L127Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> tmp = startSet;
                startSet = endSet;
                endSet = tmp;
            }
            Set<String> next = new HashSet<>();
            for (String s : startSet) {
                char[] cur = s.toCharArray();
                for (int i = 0; i < cur.length; i++) {
                    char temp = cur[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == temp) {
                            continue;
                        }
                        cur[i] = j;
                        String str = new String(cur);
                        if (endSet.contains(str)) {
                            return len + 1;
                        }
                        if (dict.contains(str)) {
                            dict.remove(str);
                            next.add(str);
                        }
                    }
                    cur[i] = temp;
                }
            }
            startSet = next;
            len++;
        }
        return 0;
    }
} 