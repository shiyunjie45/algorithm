package com.sky.algorithmleetcode;

/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。  上图为 8 皇后问题的一种解法。 给定一个整数 n，返回 n
 皇后不同的解决方案的数量。 示例: 输入: 4 输出: 2 解释: 4 皇后问题存在如下两个不同的解法。 [  [".Q..",  // 解法 1   "..
.Q",   "Q...",   "..Q."],  ["..Q.",  // 解法 2   "Q...",   "...Q",   ".Q.."] ]    
提示：  	皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一
或七步，可进可退。（引用自 百度百科 - 皇后 ）
*/

 class L52Solution {
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        backtrack(0, n, col, diag1, diag2);
        return count;
    }

    public void backtrack(int row, int n, boolean[] col, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            int d1 = row - i + n - 1;
            int d2 = row + i;
            if (col[i] || diag1[d1] || diag2[d2]) {
                continue;
            }
            col[i] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            backtrack(row + 1, n, col, diag1, diag2);
            col[i] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
} 