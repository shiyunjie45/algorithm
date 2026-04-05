package com.sky.algorithmleetcode;

/*
给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。 子矩阵 x1, y1, x2, y2 是满足 x1  且 y1  的
所有单元 matrix[x][y] 的集合。 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如
：x1 != x1'），那么这两个子矩阵也不同。   示例 1： 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target =
 0 输出：4 解释：四个只含 0 的 1x1 子矩阵。  示例 2： 输入：matrix = [[1,-1],[-1,1]], target = 0 输出：5
 解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。    提示：  	1 	1 	-1000 	-10^8
*/

 class L1074Solution {
    
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        
        // 计算矩阵每一行的前缀和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + matrix[i - 1][j - 1];
            }
        }
        
        int res = 0;
        // 枚举子矩阵的上边界和下边界
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int cur = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                
                // 枚举子矩阵的右边界，并计算子矩阵的和
                for (int k = 1; k <= n; k++) {
                    cur += sum[j][k] - sum[i - 1][k];
                    res += map.getOrDefault(cur - target, 0);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        
        return res;
    }
} 