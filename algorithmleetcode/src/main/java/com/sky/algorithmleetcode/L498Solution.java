package com.sky.algorithmleetcode;

/*
给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。   示例: 输入: [ [ 1,
 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] 输出: [1,2,4,7,5,3,6,8,9] 解释:    说明:  	给定矩阵中的元
素总数不会超过 100000 。
*/

 class L498Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int r = 0, c = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {  // 向右上走
                if (c == n - 1) {     // 往上走
                    r++;
                } else if (r == 0) {  // 往右走
                    c++;
                } else {              // 右上方
                    r--;
                    c++;
                }
            } else {                  // 向左下走
                if (r == m - 1) {     // 往右走
                    c++;
                } else if (c == 0) {  // 往下走
                    r++;
                } else {              // 左下方
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
} 