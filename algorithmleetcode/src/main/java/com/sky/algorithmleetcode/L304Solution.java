package com.sky.algorithmleetcode;

/*
给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。  上图子矩阵左上角 (ro
w1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。 示例: 给定 matrix = [  [
3, 0, 1, 4, 2],  [5, 6, 3, 2, 1],  [1, 2, 0, 1, 5],  [4, 1, 0, 1, 7],  [1, 0, 3,
 0, 5] ] sumRegion(2, 1, 4, 3) -> 8 sumRegion(1, 1, 2, 2) -> 11 sumRegion(1, 2, 
2, 4) -> 12  说明:  	你可以假设矩阵不可变。 	会多次调用 sumRegion 方法。 	你可以假设 row1 ≤ row2 且 col1 ≤ 
col2。
*/

 class L304Solution {

    int[][] sumMatrix;

    /**
     * 构造函数，用于预处理矩阵，计算每个子矩阵的和
     *
     * @param matrix
     */
    public L304Solution(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        sumMatrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    /**
     * 求矩阵[row1，col1]- [row2，col2]的元素总和
     *
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row2 + 1][col1] - sumMatrix[row1][col2 + 1] + sumMatrix[row1][col1];
    }
} 