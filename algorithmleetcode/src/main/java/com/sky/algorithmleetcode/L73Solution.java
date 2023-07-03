package com.sky.algorithmleetcode;

/*
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。 示例 1: 输入: [   [1,1,1],   [1
,0,1],   [1,1,1] ] 输出: [   [1,0,1],   [0,0,0],   [1,0,1] ]  示例 2: 输入: [   [0,1,2
,0],   [3,4,5,2],   [1,3,1,5] ] 输出: [   [0,0,0,0],   [0,4,5,0],   [0,3,1,0] ] 进阶
:  	一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。 	一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是
最好的解决方案。 	你能想出一个常数空间的解决方案吗？
*/

 L73Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowFlag = false;  // 第一行是否有0的标记
        boolean colFlag = false;  // 第一列是否有0的标记
        
        // 遍历第一行，判断是否有0
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowFlag = true;
                break;
            }
        }
        
        // 遍历第一列，判断是否有0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }
        
        // 遍历剩下的元素，如果为0，将对应的第一行和第一列标记为0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // 遍历第一行，如果元素为0，将对应的列置为0
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // 遍历第一列，如果元素为0，将对应的行置为0
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // 如果第一行有0，将第一行全部置为0
        if (rowFlag) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // 如果第一列有0，将第一列全部置为0
        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
} 