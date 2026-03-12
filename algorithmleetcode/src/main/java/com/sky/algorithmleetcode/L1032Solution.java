package com.sky.algorithmleetcode;

/*
按下述要求实现 StreamChecker 类：  	StreamChecker(words)：构造函数，用给定的字词初始化数据结构。 	query(lette
r)：如果存在某些 k >= 1，可以用查询的最后 k个字符（按从旧到新顺序，包括刚刚查询的字母）拼写出给定字词表中的某一字词时，返回 true。否则，返回 f
alse。    示例： StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); /
/ 初始化字典 streamChecker.query('a');     // 返回 false streamChecker.query('b');     
// 返回 false streamChecker.query('c');     // 返回 false streamChecker.query('d'); 
    // 返回 true，因为 'cd' 在字词表中 streamChecker.query('e');     // 返回 false streamChe
cker.query('f');     // 返回 true，因为 'f' 在字词表中 streamChecker.query('g');     // 返回
 false streamChecker.query('h');     // 返回 false streamChecker.query('i');     /
/ 返回 false streamChecker.query('j');     // 返回 false streamChecker.query('k');  
   // 返回 false streamChecker.query('l');     // 返回 true，因为 'kl' 在字词表中。   提示：  	1
 	1 	字词只包含小写英文字母。 	待查项只包含小写英文字母。 	待查项最多 40000 个。
*/

 java.util.*;

class Trie {
    class Node {
        char c;
        Node[] children = new Node[26];
        boolean isWord;
        
        public Node(char c) {
            this.c = c;
        }
    }
    
    Node root;
    
    public Trie() {
        root = new Node('#');
    }
    
    public void insert(String word) {
        Node curr = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(ArrayDeque<Character> q) {
        Node curr = root;
        for (char c : q) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
            if (curr.isWord) {
                return true;
            }
        }
        return false;
    }
}

class StreamChecker {
    Trie trie;
    ArrayDeque<Character> deque;

    public StreamChecker(String[] words) {
        trie = new Trie();
        deque = new ArrayDeque<Character>();
        for (String word : words) {
            trie.insert(word);
        }
    }

    public boolean query(char letter) {
        deque.addFirst(letter);
        return trie.search(deque);
    }
}

public class L1032Solution {
    public static void main(String[] args) {
        String[] words = {"cd","f","kl"};
        StreamChecker streamChecker = new StreamChecker(words);
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));
        System.out.println(streamChecker.query('e'));
        System.out.println(streamChecker.query('f'));
        System.out.println(streamChecker.query('g'));
        System.out.println(streamChecker.query('h'));
        System.out.println(streamChecker.query('i'));
        System.out.println(streamChecker.query('j'));
        System.out.println(streamChecker.query('k'));
        System.out.println(streamChecker.query('l'));
    }
} 