package com.sky.algorithmleetcode;

/*
在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。 （请注意，反
斜杠字符是转义的，因此 \ 用 "\\" 表示。）。 返回区域的数目。     示例 1： 输入： [   " /",   "/ " ] 输出：2 解释：2x2
 网格如下：  示例 2： 输入： [   " /",   " " ] 输出：1 解释：2x2 网格如下：  示例 3： 输入： [   "\\/",   "/
\\" ] 输出：4 解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。） 2x2 网格如下：  示例 4： 
输入： [   "/\\",   "\\/" ] 输出：5 解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。
） 2x2 网格如下：  示例 5： 输入： [   "//",   "/ " ] 输出：3 解释：2x2 网格如下：    提示：  	1 	grid[i][
j] 是 '/'、'\'、或 ' '。
*/

 L959Solution {
    private int count;

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        count = n * n * 4; // 初始化区域数

        int[][] matrix = new int[n*3][n*3]; // 构建一个大矩阵，每个小方格变成一个大小为 3 的小矩阵

        // 将原来的方格扩大为 3 倍，并进行填充
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                int left = j * 3;
                int top = i * 3;

                if (ch == '/') {
                    matrix[top][left + 2] = matrix[top + 1][left + 1] = matrix[top + 2][left] = 1;
                    count--; // 消去一个区域
                } else if (ch == '\\') {
                    matrix[top][left] = matrix[top + 1][left + 1] = matrix[top + 2][left + 2] = 1;
                    count--; // 消去一个区域
                }
            }
        }

        // 进行图搜索，求解区域数
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[n * 3][n * 3];
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (!visited[i][j] && matrix[i][j] == 0) {
                    dfs(matrix, visited, directions, i, j);
                    count++; // 完成一个区域的搜索
                }
            }
        }

        return count;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int[][] directions, int i, int j) {
        visited[i][j] = true;

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length && !visited[ni][nj] && matrix[ni][nj] == 0) {
                dfs(matrix, visited, directions, ni, nj);
            }
        }
    }
} 