package com.sky.algorithmleetcode;

/*
给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。 我们转换其中一个图像，向左，右，上，或下滑动任何数量的
单位，并把它放在另一个图像的上面。之后，该转换的重叠是指两个图像都具有 1 的位置的数目。 （请注意，转换不包括向任何方向旋转。） 最大可能的重叠是什么？ 示例
 1: 输入：A = [[1,1,0],      [0,1,0],       [0,1,0]]    B = [[0,0,0],       [0,1,1]
,       [0,0,1]] 输出：3 解释: 将 A 向右移动一个单位，然后向下移动一个单位。 注意:   	1 	0
*/

 class L835Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int maxOverlap = 0;
        int n = A.length;
        for (int i = -n + 1; i < n; i++) {
            for (int j = -n + 1; j < n; j++) {
                int count = 0;
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        if (x + i < 0 || x + i >= n || y + j < 0 || y + j >= n)
                            continue;
                        if (A[x][y] == 1 && B[x + i][y + j] == 1)
                            count++;
                    }
                }
                maxOverlap = Math.max(maxOverlap, count);
            }
        }
        return maxOverlap;
    }
} 