package com.sky.algorithmleetcode;

/*
给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。 题目保证至少有一个词不在禁用列表中，而
且答案唯一。 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。   示例： 输入: paragraph = "Bob 
hit a ball, the hit BALL flew far after it was hit." banned = ["hit"] 输出: "ball"
 解释: "hit" 出现了3次，但它是一个禁用的单词。 "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中
的单词。 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"）， "hit"不是最终的答案，虽然它出现次数
更多，但它在禁用单词列表中。    提示：  	1 	0 	1 	答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词
，答案都是小写的。) 	paragraph 只包含字母、空格和下列标点符号!?',;. 	不存在没有连字符或者带有连字符的单词。 	单词里只包含字母，不会出现省
略号或者其他标点符号。
*/

 java.util.*;

public class L819Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 将段落中所有非字母字符替换为空格，并将所有单词转换为小写
        String[] words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");
        // 建立哈希表，存储每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!word.equals("")) { // 排除空字符串
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        // 将禁用单词放入哈希集合中
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        // 找出出现次数最多，且不在禁用单词列表中的单词
        String res = "";
        int maxCount = 0;
        for (String word : map.keySet()) {
            if (!bannedSet.contains(word) && map.get(word) > maxCount) {
                res = word;
                maxCount = map.get(word);
            }
        }
        return res;
    }
} 