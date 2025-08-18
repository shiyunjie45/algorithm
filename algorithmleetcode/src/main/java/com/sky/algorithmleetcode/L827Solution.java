package com.sky.algorithmleetcode;

/*
在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。 进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连
的 1 可形成岛屿） 示例 1:  输入: [[1, 0], [0, 1]] 输出: 3 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。  示
例 2:  输入: [[1, 1], [1, 0]] 输出: 4 解释: 将一格0变成1，岛屿的面积扩大为 4。 示例 3:  输入: [[1, 1], [1,
 1]] 输出: 4 解释: 没有0可以让我们变成1，面积依然为 4。 说明:  	1 	0
*/

 class L827Solution {
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 四个方向
    private int rows;
    private int cols;
    private int[][] grid;
    private boolean[][] visited;

    public int largestIsland(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[rows][cols];
        int maxArea = 0;
        boolean hasZero = false; // 是否有0

        // 遍历所有土地，找到最大的陆地
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    grid[i][j] = 1;
                    maxArea = Math.max(maxArea, getArea(i, j));
                    grid[i][j] = 0;
                }
            }
        }

        // 如果没有0，则整个地图都是陆地
        if (!hasZero) {
            return rows * cols;
        }

        return maxArea;
    }

    // 计算从某个土地开始的最大连通块面积
    private int getArea(int x, int y) {
        visited[x][y] = true;
        int area = 1;
        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY] && grid[newX][newY] == 1) {
                area += getArea(newX, newY);
            }
        }
        return area;
    }
} 