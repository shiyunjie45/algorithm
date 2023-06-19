package com.sky.algorithmleetcode;

/*
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 示例: 输入: 3 输出: [ [ 1, 2, 3 ], [
 8, 9, 4 ], [ 7, 6, 5 ] ]
*/

 class L59Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n]; // 创建 n*n 矩阵
        int num = 1;    // 从 1 开始填入数字
        int left = 0, right = n - 1;    // left为左边界，right为右边界
        int top = 0, bottom = n - 1;    // top为上边界，bottom为下边界
        
        while (num <= n * n) {
            // 从左到右填充数字
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num;
                num++;
            }
            top++;  // 上边界下移一位
            // 从上到下填充数字
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num;
                num++;
            }
            right--;    // 右边界左移一位
            // 从右到左填充数字
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num;
                num++;
            }
            bottom--;   // 下边界上移一位
            // 从下到上填充数字
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num;
                num++;
            }
            left++; // 左边界右移一位
        }
        return matrix;
    }
} 