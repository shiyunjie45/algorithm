package com.sky.algorithmleetcode;

/*
两个玩家分别扮演猫（Cat）和老鼠（Mouse）在无向图上进行游戏，他们轮流行动。 该图按下述规则给出：graph[a] 是所有结点 b 的列表，使得 ab 是
图的一条边。 老鼠从结点 1 开始并率先出发，猫从结点 2 开始且随后出发，在结点 0 处有一个洞。 在每个玩家的回合中，他们必须沿着与他们所在位置相吻合的图的
一条边移动。例如，如果老鼠位于结点 1，那么它只能移动到 graph[1] 中的（任何）结点去。 此外，猫无法移动到洞（结点 0）里。 然后，游戏在出现以下三种
情形之一时结束：  	如果猫和老鼠占据相同的结点，猫获胜。 	如果老鼠躲入洞里，老鼠获胜。 	如果某一位置重复出现（即，玩家们的位置和移动顺序都与上一个回合相同
），游戏平局。  给定 graph，并假设两个玩家都以最佳状态参与游戏，如果老鼠获胜，则返回 1；如果猫获胜，则返回 2；如果平局，则返回 0。     示例：
 输入：[[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]] 输出：0 解释： 4---3---1 |   | 2---5  \ 
/   0    提示：  	3 	保证 graph[1] 非空。 	保证 graph[2] 包含非零元素。
*/

 java.util.*;

public class L913Solution {
    public int catMouseGame(int[][] graph) {
        int N = graph.length; // 图中所有节点的数量
        int DRAW = 0, MOUSE = 1, CAT = 2; // 胜负结果编号，老鼠编号，猫编号
        int[][][] color = new int[50][50][3]; // 节点的颜色，0为DRAW，1为MOUSE，2为CAT
        int[][][] degree = new int[50][50][3]; // 节点的度数
        int[][][] graphColor = new int[50][50][3]; // 当前游戏状态下节点的颜色

        // 初始化color和degree，同时统计出图中MOUSE和CAT的位置，方便后续的状态判断
        int mouse = 0, cat = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(color[i][j], DRAW);
                degree[i][j][1] = graph[i].length;
                degree[i][j][2] = graph[j].length;
                for (int k = 0; k < graph[j].length; k++) {
                    if (graph[j][k] == 0) {
                        degree[i][j][2]--;
                        break;
                    }
                }
                if (i == 0) {
                    color[i][j][1] = MOUSE;
                }
                if (i == j) {
                    for (int k = 0; k < 3; k++) {
                        color[i][j][k] = CAT;
                    }
                }
            }
        }

        // 初始化当前游戏状态下节点的颜色
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i < N; i++) {
            for (int t = 1; t <= 2; t++) {
                graphColor[0][i][t] = MOUSE;
                queue.offer(new int[]{0, i, t, MOUSE});
                if (i > 1) {
                    graphColor[i][i][t] = CAT;
                    queue.offer(new int[]{i, i, t, CAT});
                }
            }
        }

        // BFS，遍历出所有节点的胜负结果，直到初始节点胜负结果得到
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0], j = node[1], t = node[2], c = node[3];
            if (color[i][j][t] == c) {
                // 如果当前节点已经访问过，且颜色一致，则跳过
                continue;
            }
            color[i][j][t] = c;
            if (c == DRAW) {
                for (int k = 0; k < graph[i].length; k++) {
                    int newI = graph[i][k];
                    if (newI == j) {
                        continue;
                    }
                    for (int nextColor : new int[]{MOUSE, CAT}) {
                        int[] next = new int[]{newI, j, 3 - t, nextColor};
                        degree[next[0]][next[1]][next[2]]--;
                        if (degree[next[0]][next[1]][next[2]] == 0) {
                            queue.offer(next);
                        }
                    }
                }
                for (int k = 0; k < graph[j].length; k++) {
                    int newJ = graph[j][k];
                    if (newJ == 0) {
                        continue;
                    }
                    int[] next = new int[]{i, newJ, 3 - t, CAT};
                    degree[next[0]][next[1]][next[2]]--;
                    if (degree[next[0]][next[1]][next[2]] == 0) {
                        queue.offer(next);
                    }
                }
            } else if (c == MOUSE) {
                for (int k = 0; k < graph[j].length; k++) {
                    int newJ = graph[j][k];
                    if (newJ == 0) {
                        continue;
                    }
                    int[] next = new int[]{i, newJ, 3 - t, CAT};
                    degree[next[0]][next[1]][next[2]]--;
                    if (degree[next[0]][next[1]][next[2]] == 0) {
                        queue.offer(next);
                    }
                }
            } else {
                for (int k = 0; k < graph[i].length; k++) {
                    int newI = graph[i][k];
                    int[] next = new int[]{newI, j, 3 - t, MOUSE};
                    degree[next[0]][next[1]][next[2]]--;
                    if (degree[next[0]][next[1]][next[2]] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return color[mouse][cat][MOUSE];
    }
} 