package com.sky.algorithmleetcode;

/*
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串
 str 中的每个非空单词之间存在着双向连接的对应规律。 示例1: 输入: pattern = "abba", str = "dog cat cat dog" 
输出: true 示例 2: 输入:pattern = "abba", str = "dog cat cat fish" 输出: false 示例 3: 输入:
 pattern = "aaaa", str = "dog cat cat dog" 输出: false 示例 4: 输入: pattern = "abba",
 str = "dog dog dog dog" 输出: false 说明: 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字
母。
*/

 class L290Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (set.contains(words[i])) {
                    return false;
                }
                map.put(c, words[i]);
                set.add(words[i]);
            } else {
                if (!map.get(c).equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }
} 