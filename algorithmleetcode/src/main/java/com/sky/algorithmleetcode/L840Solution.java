package com.sky.algorithmleetcode;

/*
3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。 给定一个由整数组成的 grid，
其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。   示例： 输入: [[4,3,8,4],    [9,5,1,9],    [2,
7,6,2]] 输出: 1 解释: 下面的子矩阵是一个 3 x 3 的幻方： 438 951 276 而这一个不是： 384 519 762 总的来说，在本示例
所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。  提示:  	1 	1 	0
*/

 class L840Solution {
    
    public static int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static boolean isMagicSquare(int[][] grid, int startRow, int startCol) {
        int[] nums = new int[10];
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (grid[i][j] > 9 || grid[i][j] < 1 || nums[grid[i][j]] > 0) {
                    return false;
                }
                nums[grid[i][j]]++;
            }
        }
        int sum = grid[startRow][startCol] + grid[startRow][startCol + 1] + grid[startRow][startCol + 2];
        for (int i = startRow + 1; i < startRow + 3; i++) {
            int rowSum = 0;
            for (int j = startCol; j < startCol + 3; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum != sum) {
                return false;
            }
        }
        for (int i = startCol; i < startCol + 3; i++) {
            int colSum = 0;
            for (int j = startRow; j < startRow + 3; j++) {
                colSum += grid[j][i];
            }
            if (colSum != sum) {
                return false;
            }
        }
        int diagonalSum1 = grid[startRow][startCol] + grid[startRow + 1][startCol + 1] + grid[startRow + 2][startCol + 2];
        int diagonalSum2 = grid[startRow + 2][startCol] + grid[startRow + 1][startCol + 1] + grid[startRow][startCol + 2];
        if (diagonalSum1 != sum || diagonalSum2 != sum) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println(numMagicSquaresInside(grid)); // output: 1
    }
} 