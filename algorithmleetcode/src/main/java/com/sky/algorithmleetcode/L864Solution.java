package com.sky.algorithmleetcode;

/*
给定一个二维网格 grid。 "." 代表一个空房间， "#" 代表一堵墙， "@" 是起点，（"a", "b", ...）代表钥匙，（"A", "B", ..
.）代表锁。 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。
除非我们手里有对应的钥匙，否则无法通过锁。 假设 K 为钥匙/锁的个数，且满足 1 ，字母表中的前 K 个字母在网格中都有自己对应的一个小写和一个大写字母。换言
之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。 返回获取所有钥匙所需要的移动的最少次数。如果无法获取
所有钥匙，返回 -1 。   示例 1： 输入：["@.a.#","###.#","b.A.B"] 输出：8  示例 2： 输入：["@..aA","..B#.
","....b"] 输出：6    提示：  	1 	1 	grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F' 
	钥匙的数目范围是 [1, 6]，每个钥匙都对应一个不同的字母，正好打开一个对应的锁。
*/

 java.util.*;

public class L864Solution {
    public int shortestPathAllKeys(String[] grid) {
        int rows = grid.length, cols = grid[0].length();
        int startX = -1, startY = -1, keyCount = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //记录状态是否访问过，第0位表示人的横坐标，第1位表示人的纵坐标，第2位表示当前钥匙状态
        boolean[][][] visited = new boolean[rows][cols][1 << 6];
        Queue<int[]> queue = new LinkedList<>();
        //将起点加入队列，同时将状态设置为没有钥匙
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i].charAt(j) == '@') {
                    startX = i;
                    startY = j;
                } else if ('a' <= grid[i].charAt(j) && grid[i].charAt(j) <= 'f') {
                    keyCount++;
                }
            }
        }
        if (keyCount == 0) { //没有钥匙，直接返回0
            return 0;
        }
        //将起点放入队列
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY][0] = true; //设置为已经访问过
        int step = 0; //记录走的步数
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll(); //取出队列中的点
                int x = point[0], y = point[1], keys = point[2];
                //枚举点的四个方向
                for (int[] direction : directions) {
                    int newX = x + direction[0], newY = y + direction[1];
                    if (newX < 0 || newX >= rows || newY < 0 || newY >= cols) { //边界检测
                        continue;
                    }
                    char c = grid[newX].charAt(newY);
                    if (c == '#') { //遇到墙直接跳过
                        continue;
                    }
                    if ('A' <= c && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0) { //遇到锁没有对应的钥匙，跳过
                        continue;
                    }
                    int newKeys = keys;
                    if ('a' <= c && c <= 'f') { //遇到钥匙，修改钥匙状态，使得新状态与原状态不同
                        newKeys |= 1 << (c - 'a');
                        if (newKeys == (1 << keyCount) - 1) { //获取了所有钥匙，直接返回
                            return step + 1;
                        }
                    }
                    if (!visited[newX][newY][newKeys]) { //新状态没有被访问过，则加入队列
                        visited[newX][newY][newKeys] = true;
                        queue.offer(new int[]{newX, newY, newKeys});
                    }
                }
            }
            step++;
        }
        return -1; //无法获取所有钥匙
    }
} 