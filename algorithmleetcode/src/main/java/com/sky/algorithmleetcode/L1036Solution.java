package com.sky.algorithmleetcode;

/*
在一个 10^6 x 10^6 的网格中，每个网格块的坐标为 (x, y)，其中 0 。 我们从源方格 source 开始出发，意图赶往目标方格 target。
每次移动，我们都可以走到网格中在四个方向上相邻的方格，只要该方格不在给出的封锁列表 blocked 上。 只有在可以通过一系列的移动到达目标方格时才返回 tru
e。否则，返回 false。   示例 1： 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2
] 输出：false 解释： 从源方格无法到达目标方格，因为我们无法在网格中移动。  示例 2： 输入：blocked = [], source = [0,0]
, target = [999999,999999] 输出：true 解释： 因为没有方格被封锁，所以一定可以到达目标方格。    提示：  	0 	block
ed[i].length == 2 	0 	source.length == target.length == 2 	0 	source != target
*/

 java.util.*;

public class L1036Solution {
    // 方向数组 右，下，左，上
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        // blockedSet 存储 blocked 数组转成的set，后面判断时用于快速查找
        Set<String> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(b[0] + "," + b[1]);
        }

        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    private boolean bfs(int[] start, int[] end, Set<String> blockedSet) {
        int maxSteps = blockedSet.size(), step = 0;
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start[0] + "," + start[1]);

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                int[] cur = queue.poll();
                if (cur[0] == end[0] && cur[1] == end[1]) {
                    return true;
                }

                for (int[] dir : directions) {
                    int newX = cur[0] + dir[0];
                    int newY = cur[1] + dir[1];
                    String newStr = newX + "," + newY;
                    
                    // 判断新位置是否越界以及是否在blocked中
                    if (newX < 0 || newX >= 1000000 || newY < 0 || newY >= 1000000 ||
                            visited.contains(newStr) || blockedSet.contains(newStr)) {
                        continue;
                    }
                    
                    // 这里是为了避免超时，在已经走了 maxSteps 步的情况下，直接判定为无法到达
                    if (++step > maxSteps) {
                        return true;
                    }

                    queue.offer(new int[]{newX, newY});
                    visited.add(newStr);
                }
            }
        }
        
        // 执行到这里，说明起点和终点之间无法相互到达
        return false;
    }
} 