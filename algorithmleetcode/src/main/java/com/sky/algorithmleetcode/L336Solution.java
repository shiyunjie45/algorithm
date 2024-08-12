package com.sky.algorithmleetcode;

/*
给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。 示例 1: 输入:
 ["abcd","dcba","lls","s","sssll"] 输出: [[0,1],[1,0],[3,2],[2,4]] 解释: 可拼接成的回文串为 [
"dcbaabcd","abcddcba","slls","llssssll"]  示例 2: 输入: ["bat","tab","cat"] 输出: [[0,
1],[1,0]] 解释: 可拼接成的回文串为 ["battab","tabbat"]
*/

import java.util.*;

public class L336Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) {
            return result;
        }

        // 将数组中的字符串插入到哈希表中，记录其下标
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        // 分别考虑每一个字符串和所有字符串的组合
        for (int i = 0; i < words.length; i++) {
            // 将当前字符串分为左右两部分
            String left = "";
            String right = words[i];
            for (int j = 0; j <= right.length(); j++) {
                // 将右半部分的字符串反转
                String r = new StringBuilder(right.substring(j)).reverse().toString();
                // 如果左半部分是回文并且右半部分的反转在哈希表中存在，则记录结果
                if (isPalindrome(left) && map.containsKey(r) && map.get(r) != i) {
                    result.add(Arrays.asList(map.get(r), i));
                }
                // 将当前字符加入左半部分
                if (j < right.length()) {
                    left += right.charAt(j);
                }
            }

            // 将当前字符串分为左右两部分
            left = words[i];
            right = "";
            for (int j = 0; j <= left.length(); j++) {
                // 将左半部分的字符串反转
                String l = new StringBuilder(left.substring(0, j)).reverse().toString();
                // 如果右半部分是回文并且左半部分的反转在哈希表中存在，则记录结果
                if (isPalindrome(right) && map.containsKey(l) && map.get(l) != i) {
                    result.add(Arrays.asList(i, map.get(l)));
                }
                // 将当前字符加入右半部分
                if (j < left.length()) {
                    right = left.charAt(j) + right;
                }
            }
        }

        return result;
    }

    // 判断一个字符串是否是回文串
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
} 