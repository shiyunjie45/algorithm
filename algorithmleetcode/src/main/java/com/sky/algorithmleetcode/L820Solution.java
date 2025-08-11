package com.sky.algorithmleetcode;

/*
给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将
其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，
直到 "#" 结束，来恢复我们之前的单词列表。 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？   示例： 输入: words = ["time", 
"me", "bell"] 输出: 10 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。    提示：  	1 	1 
	每个单词都是小写字母 。
*/

 java.util.Arrays;
import java.util.Comparator;

public class L820Solution {

    public int minimumLengthEncoding(String[] words) {
        // 按单词长度从长到短排序
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (String word : words) {
            // 如果当前单词已经包含在编码字符串中，直接跳过
            if (sb.indexOf(word + "#") != -1) {
                continue;
            }
            sb.append(word).append("#");
            index += word.length() + 1;
        }

        return index;
    }
} 