package com.sky.algorithmleetcode;

/*
给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 且 0 。 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。 返
回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，
|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）   示例 1： 输入：R = 1, C = 2, r0 = 0, c0 
= 0 输出：[[0,0],[0,1]] 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]  示例 2： 输入：R = 2, C = 2, r0 =
 0, c0 = 1 输出：[[0,1],[0,0],[1,1],[1,0]] 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2] [[0,1
],[1,1],[0,0],[1,0]] 也会被视作正确答案。  示例 3： 输入：R = 2, C = 3, r0 = 1, c0 = 2 输出：[[1,2]
,[0,2],[1,1],[0,1],[1,0],[0,0]] 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3] 其他满足题目要求的
答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。    提示：  	1 	1 	0 	0
*/

 java.util.*;

class L1030Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        // 创建结果数组，并将起始点置为已访问
        int[][] result = new int[R * C][2];
        boolean[][] visited = new boolean[R][C];
        result[0] = new int[]{r0, c0};
        visited[r0][c0] = true;
        int index = 1;
        
        // 创建队列，并将起始点加入队列
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});

        // 依次遍历队列中的元素，直到队列为空
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];

                // 分别访问当前元素上下左右四个方向的元素
                if (r-1 >= 0 && !visited[r-1][c]) {
                    result[index++] = new int[]{r-1, c};
                    visited[r-1][c] = true;
                    queue.offer(new int[]{r-1, c});
                }
                if (r+1 < R && !visited[r+1][c]) {
                    result[index++] = new int[]{r+1, c};
                    visited[r+1][c] = true;
                    queue.offer(new int[]{r+1, c});
                }
                if (c-1 >= 0 && !visited[r][c-1]) {
                    result[index++] = new int[]{r, c-1};
                    visited[r][c-1] = true;
                    queue.offer(new int[]{r, c-1});
                }
                if (c+1 < C && !visited[r][c+1]) {
                    result[index++] = new int[]{r, c+1};
                    visited[r][c+1] = true;
                    queue.offer(new int[]{r, c+1});
                }
            }
        }
        
        return result;
    }
} 