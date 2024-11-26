package com.sky.algorithmleetcode;

/*
给定一个不含重复单词的列表，编写一个程序，返回给定单词列表中所有的连接词。 连接词的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。 示例:  输入:
 ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdo
gcat"] 输出: ["catsdogcats","dogcatsdog","ratcatdogcat"] 解释: "catsdogcats"由"cats",
 "dog" 和 "cats"组成;    "dogcatsdog"由"dog", "cats"和"dog"组成;    "ratcatdogcat"由"rat
", "cat", "dog"和"cat"组成。  说明:  	给定数组的元素总数不超过 10000。 	给定数组中元素的长度总和不超过 600000。 	所有
输入字符串只包含小写字母。 	不需要考虑答案输出的顺序。
*/

 java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L472Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();

        // 将单词数组转化为单词集合
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }

        // 遍历单词数组，查找连接词
        for (String word : words) {
            if (word.length() == 0) continue;

            // 初始化动态规划数组
            boolean[] dp = new boolean[word.length() + 1];
            dp[0] = true;

            // 计算动态规划数组
            for (int i = 0; i < word.length(); i++) {
                if (!dp[i]) continue;

                for (int j = i + 1; j <= word.length(); j++) {
                    // 判断当前字符串子串是否为单词集合中的单词
                    if (j - i < word.length() && wordSet.contains(word.substring(i, j))) {
                        dp[j] = true;
                    }
                }

                // 进一步判断是否为连接词
                if (dp[word.length()]) {
                    result.add(word);
                    break;
                }
            }
        }
        return result;
    }
} 