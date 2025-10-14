package com.sky.algorithmleetcode;

/*
给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。） 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么
这个单词就是不常见的。 返回所有不常用单词的列表。 您可以按任何顺序返回列表。     示例 1： 输入：A = "this apple is sweet", 
B = "this apple is sour" 输出：["sweet","sour"]  示例 2： 输入：A = "apple apple", B = "b
anana" 输出：["banana"]    提示：  	0 	0 	A 和 B 都只包含空格和小写字母。
*/

 java.util.*;

public class L884Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] strA = A.split(" ");
        String[] strB = B.split(" ");
        for (String str : strA) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : strB) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
} 