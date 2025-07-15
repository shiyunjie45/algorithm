package com.sky.algorithmleetcode;

/*
给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。  示例: 输入: S = "abcde" words = ["a
", "bb", "acd", "ace"] 输出: 3 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。  注意:  	所有在wo
rds和 S 里的单词都只由小写字母组成。 	S 的长度在 [1, 50000]。 	words 的长度在 [1, 5000]。 	words[i]的长度在[1
, 50]。
*/

 java.util.*;

class L792Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        Map<Character, Queue<String>> map = new HashMap<>();
        for (String word : words) {
            char firstChar = word.charAt(0);
            if (!map.containsKey(firstChar)) {
                map.put(firstChar, new LinkedList<>());
            }
            map.get(firstChar).add(word);
        }
        for (char ch : S.toCharArray()) {
            Queue<String> queue = map.getOrDefault(ch, new LinkedList<>());
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.length() == 1) {
                    // word是S的子序列
                    count++;
                } else {
                    char nextChar = word.charAt(1);
                    if (!map.containsKey(nextChar)) {
                        map.put(nextChar, new LinkedList<>());
                    }
                    map.get(nextChar).add(word.substring(1));
                }
            }
        }
        return count;
    }
} 