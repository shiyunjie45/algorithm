package com.sky.algorithmleetcode;

/*
给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答
案中字典序最小的单词。 若无答案，则返回空字符串。 示例 1:  输入: words = ["w","wo","wor","worl", "world"] 输出
: "world" 解释: 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。  示例 2:  输入: words =
 ["a", "banana", "app", "appl", "ap", "apply", "apple"] 输出: "apple" 解释: "apply"和
"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。  注意:  	所有输入的字符串都只包含小写字母。 	words数组长度范围
为[1,1000]。 	words[i]的长度范围为[1,30]。
*/

 java.util.*;

class TrieNode {
    char val;
    boolean isWord;
    Map<Character, TrieNode> children;

    public TrieNode(char val) {
        this.val = val;
        isWord = false;
        children = new HashMap<>();
    }
}

public class L720Solution {
    private TrieNode root;

    public String longestWord(String[] words) {
        root = new TrieNode(' ');
        for (String word : words) {
            insertWord(word);
        }
        return dfs(root, "");
    }

    private void insertWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode(c));
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    private String dfs(TrieNode node, String path) {
        if (!node.isWord) {
            return "";
        }
        String res = path;
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.children.containsKey(c)) {
                res = dfs(node.children.get(c), path + c);
            }
        }
        return res;
    }
} 