package com.sky.algorithmleetcode;

/*
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 两个相邻元素间的距离为 1 。 示例 1: 输入:  0 0 0 0 1 0 0 0 0
  输出:  0 0 0 0 1 0 0 0 0  示例 2: 输入:  0 0 0 0 1 0 1 1 1  输出:  0 0 0 0 1 0 1 2 1  
注意:  	给定矩阵的元素个数不超过 10000。 	给定矩阵中至少有一个元素是 0。 	矩阵中的元素只在四个方向上相邻: 上、下、左、右。
*/

 java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L542Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dist = new int[m][n];
        for(int[] row: dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir: dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x>=0 && x<m && y>=0 && y<n) {
                    if(dist[x][y] > dist[curr[0]][curr[1]] + 1) {
                        dist[x][y] = dist[curr[0]][curr[1]] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }

        return dist;
    }
} 