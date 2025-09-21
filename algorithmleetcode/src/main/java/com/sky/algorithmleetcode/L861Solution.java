package com.sky.algorithmleetcode;

/*
有一个二维矩阵 A 其中每个元素的值为 0 或 1 。 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 返回尽可能高的分数。     示例： 输入：[[0,0,1,1]
,[1,0,1,0],[1,1,0,0]] 输出：39 解释： 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]] 0b1111 + 0b1
001 + 0b1111 = 15 + 9 + 15 = 39   提示：  	1 	1 	A[i][j] 是 0 或 1
*/

 class L861Solution {
    public int matrixScore(int[][] A) {
        int rows = A.length, cols = A[0].length;

        // 保证第一列全为1
        for (int i = 0; i < rows; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < cols; j++) {
                    A[i][j] ^= 1;
                }
            }
        }

        // 翻转其他列，保证每列1的个数更多
        for (int j = 1; j < cols; j++) {
            int count = 0;
            for (int i = 0; i < rows; i++) {
                if (A[i][j] == 1) count++;
            }
            if (count < (rows + 1) / 2) {
                for (int i = 0; i < rows; i++) {
                    A[i][j] ^= 1;
                }
            }
        }

        // 计算结果
        int res = 0;
        for (int i = 0; i < rows; i++) {
            int row = 0;
            for (int j = 0; j < cols; j++) {
                row = row * 2 + A[i][j];
            }
            res += row;
        }
        return res;
    }
} 