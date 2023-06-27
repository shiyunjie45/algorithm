package com.sky.algorithmleetcode;

/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。  上图为 8 皇后问题的一种解法。 给定一个整数 n，返回所有
不同的 n 皇后问题的解决方案。 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 示例: 输入: 4
 输出: [ [".Q..", // 解法 1  "...Q",  "Q...",  "..Q."],  ["..Q.", // 解法 2  "Q...",  
"...Q",  ".Q.."] ] 解释: 4 皇后问题存在两个不同的解法。    提示：  	皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那
就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class L51Solution {
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        backtrack(n, 0, queens, cols, diag1, diag2);
        return res;
    }

    private void backtrack(int n, int row, int[] queens, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            res.add(generateBoard(queens, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            int dia1 = row + col;
            int dia2 = row - col + n - 1;
            if (!cols[col] && !diag1[dia1] && !diag2[dia2]) {
                queens[row] = col;
                cols[col] = true;
                diag1[dia1] = true;
                diag2[dia2] = true;
                backtrack(n, row + 1, queens, cols, diag1, diag2);
                queens[row] = -1;
                cols[col] = false;
                diag1[dia1] = false;
                diag2[dia2] = false;
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
} 