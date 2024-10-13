package com.sky.algorithmleetcode;

/*
给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 规定水流只能按
照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。   提示：  
	输出坐标的顺序不重要 	m 和 n 都小于150    示例：    给定下面的 5x5 矩阵:  太平洋 ~  ~  ~  ~  ~     ~ 1  2 
 2  3 (5) *    ~ 3  2  3 (4) (4) *    ~ 2  4 (5) 3  1 *    ~ (6) (7) 1  4  5 *  
  ~ (5) 1  1  2  4 *      *  *  *  *  * 大西洋 返回: [[0, 4], [1, 3], [1, 4], [2, 2],
 [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
*/

 java.util.ArrayList;
import java.util.List;

public class L417Solution {
    private int rows, cols;
    private int[][] matrix;
    private boolean[][] canReachPacific, canReachAtlantic;
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        canReachPacific = new boolean[rows][cols];
        canReachAtlantic = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, canReachPacific);
            dfs(i, cols - 1, canReachAtlantic);
        }
        for (int j = 0; j < cols; j++) {
            dfs(0, j, canReachPacific);
            dfs(rows - 1, j, canReachAtlantic);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void dfs(int x, int y, boolean[][] canReach) {
        if (canReach[x][y]) {
            return;
        }
        canReach[x][y] = true;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && matrix[nextX][nextY] >= matrix[x][y]) {
                dfs(nextX, nextY, canReach);
            }
        }
    }
} 