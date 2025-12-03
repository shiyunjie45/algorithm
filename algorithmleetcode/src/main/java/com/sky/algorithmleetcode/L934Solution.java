package com.sky.algorithmleetcode;

/*
在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。） 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。 返回
必须翻转的 0 的最小数目。（可以保证答案至少是 1。）   示例 1： 输入：[[0,1],[1,0]] 输出：1  示例 2： 输入：[[0,1,0],[0
,0,0],[0,0,1]] 输出：2  示例 3： 输入：[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[
1,1,1,1,1]] 输出：1   提示：  	1 	A[i][j] == 0 或 A[i][j] == 1
*/

 java.util.LinkedList;
import java.util.Queue;

public class L934Solution {
    private int n;

    public int shortestBridge(int[][] A) {
        n = A.length;
        boolean[][] flag = new boolean[n][n];
        boolean found = false;
        Queue<int[]> qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, qu, flag);
                    found = true;
                    break;
                }
            }
        }

        int steps = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int[] cur = qu.poll();
                for (int j = 0; j < 4; j++) {
                    int ni = cur[0] + dirs[j][0];
                    int nj = cur[1] + dirs[j][1];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < n && !flag[ni][nj]) {
                        flag[ni][nj] = true;
                        if (A[ni][nj] == 1) {
                            return steps;
                        }
                        qu.offer(new int[]{ni, nj});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int[][] A, int i, int j, Queue<int[]> qu, boolean[][] flag) {
        if (i < 0 || i >= n || j < 0 || j >= n || flag[i][j] || A[i][j] == 0) return;
        flag[i][j] = true;
        qu.offer(new int[]{i, j});
        dfs(A, i - 1, j, qu, flag);
        dfs(A, i + 1, j, qu, flag);
        dfs(A, i, j - 1, qu, flag);
        dfs(A, i, j + 1, qu, flag);
    }
} 