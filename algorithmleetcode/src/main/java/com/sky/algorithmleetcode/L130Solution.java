package com.sky.algorithmleetcode;

/*
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 示例: X X X
 X X O O X X X O X X O X X  运行你的函数后，矩阵变为： X X X X X X X X X X X X X O X X  解释: 被
围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 
'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
*/

 class L130Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        // 将边缘的'O'标记为'#'
        for (int i = 0; i < rows; i++) {
            mark(board, i, 0, '#');
            mark(board, i, cols - 1, '#');
        }
        for (int j = 1; j < cols - 1; j++) {
            mark(board, 0, j, '#');
            mark(board, rows - 1, j, '#');
        }
        // 标记与边缘联通的'O'为'#'
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (board[i][j] == 'O') {
                    if (board[i - 1][j] == '#' || board[i + 1][j] == '#' || board[i][j - 1] == '#' || board[i][j + 1] == '#') {
                        mark(board, i, j, '#');
                    }
                }
            }
        }
        // 将剩下的'O'改为'X'，将'#'改回'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void mark(char[][] board, int i, int j, char mark) {
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = mark;
        if (i > 0) {
            mark(board, i - 1, j, mark);
        }
        if (j > 0) {
            mark(board, i, j - 1, mark);
        }
        if (i < board.length - 1) {
            mark(board, i + 1, j, mark);
        }
        if (j < board[0].length - 1) {
            mark(board, i, j + 1, mark);
        }
    }
} 