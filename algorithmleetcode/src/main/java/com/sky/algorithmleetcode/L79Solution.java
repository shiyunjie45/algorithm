package com.sky.algorithmleetcode;

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格
。同一个单元格内的字母不允许被重复使用。   示例: board = [  ['A','B','C','E'],  ['S','F','C','S'],  ['
A','D','E','E'] ] 给定 word = "ABCCED", 返回 true 给定 word = "SEE", 返回 true 给定 word =
 "ABCB", 返回 false   提示：  	board 和 word 中只包含大写和小写英文字母。 	1 	1 	1
*/

 class L79Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(board, visited, i + 1, j, word, index + 1) || dfs(board, visited, i - 1, j, word, index + 1)
                || dfs(board, visited, i, j + 1, word, index + 1) || dfs(board, visited, i, j - 1, word, index + 1);
        visited[i][j] = false;
        return res;
    }
} 