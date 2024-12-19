package com.sky.algorithmleetcode;

/*
给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。          示例：  输入: ["Hello", "Alaska", 
"Dad", "Peace"] 输出: ["Alaska", "Dad"]      注意：   	你可以重复使用键盘上同一字符。 	你可以假设输入的字符串将只
包含字母。
*/

 java.util.*;

public class L500Solution {
    public String[] findWords(String[] words) {
        List<String> result = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        String[] lines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < lines.length; i++) {
            for (char c : lines[i].toCharArray()) {
                map.put(c, i);
            }
        }
        for (String s : words) {
            int line = map.get(s.toLowerCase().charAt(0));
            boolean same = true;
            for (char c : s.toLowerCase().toCharArray()) {
                if (map.get(c) != line) {
                    same = false;
                    break;
                }
            }
            if (same) {
                result.add(s);
            }
        }
        return result.toArray(new String[result.size()]);
    }
} 