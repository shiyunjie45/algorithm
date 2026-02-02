package com.sky.algorithmleetcode;

/*
在给定的网格中，每个单元格可以有以下三个值之一：  	值 0 代表空单元格； 	值 1 代表新鲜橘子； 	值 2 代表腐烂的橘子。  每分钟，任何与腐烂的橘子（
在 4 个正方向上）相邻的新鲜橘子都会腐烂。 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。   示例 1：  输入：[[2,
1,1],[1,1,0],[0,1,1]] 输出：4  示例 2： 输入：[[2,1,1],[0,1,1],[1,0,1]] 输出：-1 解释：左下角的橘子（第
 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。  示例 3： 输入：[[0,2]] 输出：0 解释：因为 0 分钟时已经没有新鲜橘子了
，所以答案就是 0 。    提示：  	1 	1 	grid[i][j] 仅为 0、1 或 2
*/

import java.util.*;

public class L994Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // 存储新鲜橘子的位置
        List<int[]> fresh = new ArrayList<>();
        // 存储腐烂橘子的位置
        List<int[]> rotten = new ArrayList<>();
        // 统计新鲜橘子的数量
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    fresh.add(new int[]{i, j});
                    count++;
                } else if (grid[i][j] == 2) {
                    rotten.add(new int[]{i, j});
                }
            }
        }
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (count > 0 && !rotten.isEmpty()) {
            minutes++;
            int size = rotten.size();
            for (int i = 0; i < size; i++) {
                int[] curr = rotten.remove(0);
                for (int[] dir : directions) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        // 将新鲜橘子腐烂
                        grid[x][y] = 2;
                        count--;
                        rotten.add(new int[]{x, y});
                    }
                }
            }
        }
        if (count > 0) {
            // 有新鲜橘子没被腐烂
            return -1;
        } else {
            // 所有新鲜橘子都被腐烂
            return minutes;
        }
    }
} 