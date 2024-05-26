package com.sky.algorithmleetcode;

/*
给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 单词必须按照字母顺序，通过相邻的单元格内的字母构成
，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。 示例: 输入: words = ["oath","pe
a","eat","rain"] and board = [  ['o','a','a','n'],  ['e','t','a','e'],  ['i','h'
,'k','r'],  ['i','f','l','v'] ] 输出: ["eat","oath"] 说明: 你可以假设所有输入都由小写字母 a-z 组成。 提
示:  	你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 	如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地
执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
*/

import java.util.ArrayList;
import java.util.List;

public class L212Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<String>();
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                dfs(board, visited, i, j, root, result);
            }
        }
        return result;
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                if(node.children[ch-'a'] == null){
                    node.children[ch-'a'] = new TrieNode();
                }
                node = node.children[ch-'a'];
            }
            node.word = word;
        }
        return root;
    }
    
    private void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode node, List<String> result){
        int row = board.length;
        int col = board[0].length;
        if(i < 0 || i >= row || j < 0 || j >= col || visited[i][j]){
            return;
        }
        char ch = board[i][j];
        if(node.children[ch-'a'] == null){
            return;
        }
        visited[i][j] = true;
        node = node.children[ch-'a'];
        if(node.word != null){
            result.add(node.word);
            node.word = null; // 避免重复添加
        }
        dfs(board, visited, i-1, j, node, result);
        dfs(board, visited, i+1, j, node, result);
        dfs(board, visited, i, j-1, node, result);
        dfs(board, visited, i, j+1, node, result);
        visited[i][j] = false;
    }
    
    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }
} 