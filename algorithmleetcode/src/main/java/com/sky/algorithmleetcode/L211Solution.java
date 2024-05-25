package com.sky.algorithmleetcode;

/*
设计一个支持以下两种操作的数据结构： void addWord(word) bool search(word)  search(word) 可以搜索文字或正则表
达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。 示例: addWord("bad") addWord("dad") addWord
("mad") search("pad") -> false search("bad") -> true search(".ad") -> true searc
h("b..") -> true  说明: 你可以假设所有单词都是由小写字母 a-z 组成的。
*/

import java.util.HashMap;
import java.util.Map;

public class L211Solution {
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public L211Solution() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    
    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent
     * any one letter.
     */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chars, int k, TrieNode node) {
        if (k == chars.length) {
            return node.isEnd();
        }
        if (chars[k] != '.') {
            return node.containsKey(chars[k]) && match(chars, k + 1, node.get(chars[k]));
        } else {
            for (TrieNode next : node.values()) {
                if (match(chars, k + 1, next)) {
                    return true;
                }
            }
        }
        return false;
    }

    class TrieNode {

        private Map<Character, TrieNode> links;

        private boolean isEnd;

        public TrieNode() {
            links = new HashMap<>();
        }

        public boolean containsKey(char ch) {
            return links.containsKey(ch);
        }

        public TrieNode get(char ch) {
            return links.get(ch);
        }

        public void put(char ch, TrieNode node) {
            links.put(ch, node);
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public Iterable<TrieNode> values() {
            return links.values();
        }
    }
} 