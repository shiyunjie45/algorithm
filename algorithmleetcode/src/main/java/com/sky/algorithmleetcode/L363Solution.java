package com.sky.algorithmleetcode;

/*
给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。 示例: 输入: matrix = [[1,0,1],[0,-2,
3]], k = 2 输出: 2 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。  说明
：  	矩阵内的矩形区域面积必须大于 0。 	如果行数远大于列数，你将如何解答呢？
*/

import java.util.TreeSet;

public class L363Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int ans = Integer.MIN_VALUE;
        // 定义行与对角线的变量
        int rowSum[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) rowSum[j] = 0;
            //开始寻找最大子矩阵
            for (int ii = i; ii < m; ii++) {
                int s = 0;
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                //利用前缀和来寻找矩阵和
                for (int j = 0; j < n; j++) {
                    rowSum[j] += matrix[ii][j];
                    s += rowSum[j];
                    Integer ceil = ts.ceiling(s - k);
                    if (ceil != null) ans = Math.max(ans, s - ceil);
                    ts.add(s);
                }
            }
        }
        return ans;
    }
} 