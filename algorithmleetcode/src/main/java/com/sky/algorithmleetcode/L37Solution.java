package com.sky.algorithmleetcode;

/*
编写一个程序，通过已填充的空格来解决数独问题。 一个数独的解法需遵循如下规则：  	数字 1-9 在每一行只能出现一次。 	数字 1-9 在每一列只能出现一次。
 	数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。  空白格用 '.' 表示。  一个数独。  答案被标成红色。 Note:  	给定的数独序
列只包含数字 1-9 和字符 '.' 。 	你可以假设给定的数独只有唯一解。 	给定数独永远是 9x9 形式的。
*/

 class L37Solution {
    // 数独问题的解法
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    // 递归求解数独
    private boolean solve(char[][] board) {
        // 遍历数独中的每一个位置
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    // 如果该位置是空格，试填数字1-9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            // 递归填下一个位置，如果已解决，则返回true
                            if (solve(board)) {
                                return true;
                            } else {
                                // 填当前位置不行，回溯到上一个位置
                                board[i][j] = '.';
                            }
                        }
                    }
                    // 前面1-9都不行，则返回false
                    return false;
                }
            }
        }
        // 数独全部填好
        return true;
    }

    // 判断数字c能否填在(i,j)位置
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // 判断当前行中是否已有数字c
            if (board[row][i] == c) {
                return false;
            }
            // 判断当前列中是否已有数字c
            if (board[i][col] == c) {
                return false;
            }
            // 判断当前3x3宫格中是否已有数字c
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
} 