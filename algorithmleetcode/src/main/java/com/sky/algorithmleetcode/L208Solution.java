package com.sky.algorithmleetcode;

/*
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 示例: Trie trie = new Trie(
); trie.insert("apple"); trie.search("apple");  // 返回 true trie.search("app");  
 // 返回 false trie.startsWith("app"); // 返回 true trie.insert("app");  trie.search
("app");   // 返回 true 说明:  	你可以假设所有的输入都是由小写字母 a-z 构成的。 	保证所有输入均为非空字符串。
*/

public class L208Solution {
    class TrieNode {
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
    }

    /** Initialize your data structure here. */
    private TrieNode root;

    public L208Solution() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (node.children[curChar - 'a'] == null) {
                node.children[curChar - 'a'] = new TrieNode();
            }
            node = node.children[curChar - 'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (node.children[curChar - 'a'] == null) {
                return false;
            }
            node = node.children[curChar - 'a'];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curChar = prefix.charAt(i);
            if (node.children[curChar - 'a'] == null) {
                return false;
            }
            node = node.children[curChar - 'a'];
        }
        return true;
    }
} 