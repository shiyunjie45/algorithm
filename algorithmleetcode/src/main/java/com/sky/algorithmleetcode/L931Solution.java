package com.sky.algorithmleetcode;

/*
给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行
所选元素最多相隔一列。   示例： 输入：[[1,2,3],[4,5,6],[7,8,9]] 输出：12 解释： 可能的下降路径有：  	[1,4,7], [1
,4,8], [1,5,7], [1,5,8], [1,5,9] 	[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [
2,6,8], [2,6,9] 	[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]  和最小的下降路径是 [1,4,7]，
所以答案是 12。   提示：  	1 	-100
*/

 class L931Solution {
    public int minFallingPathSum(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] dp = new int[rows][cols];

        // 将第一行拷贝到dp数组中
        for (int i = 0; i < cols; i++) {
            dp[0][i] = A[0][i];
        }

        // 从第二行开始进行动态规划
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 计算上一行与当前位置相邻的三个位置的最小值
                int minVal = dp[i - 1][j];
                if (j > 0) {
                    minVal = Math.min(minVal, dp[i - 1][j - 1]);
                }
                if (j < cols - 1) {
                    minVal = Math.min(minVal, dp[i - 1][j + 1]);
                }

                // 将当前位置的值加上最小值，更新dp数组
                dp[i][j] = A[i][j] + minVal;
            }
        }

        // 找到dp数组最后一行的最小值，即为结果
        int result = dp[rows - 1][0];
        for (int i = 1; i < cols; i++) {
            result = Math.min(result, dp[rows - 1][i]);
        }
        return result;
    }
} 