package com.sky.algorithmleetcode;

/*
给定由若干 0 和 1 组成的矩阵 matrix，从中选出任意数量的列并翻转其上的 每个 单元格。翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。 
返回经过一些翻转后，行上所有值都相等的最大行数。     示例 1： 输入：[[0,1],[1,1]] 输出：1 解释：不进行翻转，有 1 行所有值都相等。  
示例 2： 输入：[[0,1],[1,0]] 输出：2 解释：翻转第一列的值之后，这两行都由相等的值组成。  示例 3： 输入：[[0,0,0],[0,0,1]
,[1,1,0]] 输出：2 解释：翻转前两列的值之后，后两行由相等的值组成。   提示：  	1 	1 	所有 matrix[i].length 都相等 	m
atrix[i][j] 为 0 或 1
*/

 java.util.HashMap;
import java.util.Map;

public class L1072Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> counts = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < row.length; i++) {
                sb1.append(row[i]);
                sb2.append(1 - row[i]);
            }
            String s1 = sb1.toString();
            String s2 = sb2.toString();
            counts.put(s1, counts.getOrDefault(s1, 0) + 1);
            counts.put(s2, counts.getOrDefault(s2, 0) + 1);
        }
        int res = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            int ones = 0;
            for (int[] row : matrix) {
                if (row[col] == 1) {
                    ones++;
                }
            }
            int flips = matrix.length - ones;
            if (ones > flips) {
                StringBuilder sb = new StringBuilder();
                for (int row = 0; row < matrix.length; row++) {
                    sb.append(matrix[row][col] ^ 1); // 翻转当前列
                }
                String s = sb.toString();
                res = Math.max(res, counts.getOrDefault(s, 0));
            } else {
                res = Math.max(res, counts.getOrDefault(matrix[0][col] + "", 0));
            }
        }
        return res;
    }
} 