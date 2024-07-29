package com.sky.algorithmleetcode;

/*
给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个
单词只包含小写字母。如果不存在这样的两个单词，返回 0。 示例 1: 输入: ["abcw","baz","foo","bar","xtfn","abcdef"
] 输出: 16 解释: 这两个单词为 "abcw", "xtfn"。 示例 2: 输入: ["a","ab","abc","d","cd","bcd","ab
cd"] 输出: 4 解释: 这两个单词为 "ab", "cd"。 示例 3: 输入: ["a","aa","aaa","aaaa"] 输出: 0 解释: 不存
在这样的两个单词。
*/

import java.util.Arrays;

public class L318Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] values = new int[n]; // 存放每个单词中的字符出现情况
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                values[i] |= 1 << (c - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((values[i] & values[j]) == 0) { // 两个单词没有相同的字符
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length()); // 更新maxProd
                }
            }
        }
        return maxProd;
    }
    
    public static void main(String[] args) {
        L318Solution solution = new L318Solution();
        String[] words1 = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(solution.maxProduct(words1)); // 输出 16
        String[] words2 = {"a","ab","abc","d","cd","bcd","abcd"};
        System.out.println(solution.maxProduct(words2)); // 输出 4
        String[] words3 = {"a","aa","aaa","aaaa"};
        System.out.println(solution.maxProduct(words3)); // 输出 0
    }
} 