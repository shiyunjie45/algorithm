package com.sky.algorithmleetcode;

/*
机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：  	-2：向左转 90 度 	-1：向右转 9
0 度 	1 ：向前移动 x 个单位长度  在网格上有一些格子被视为障碍物。 第 i 个障碍物位于网格点  (obstacles[i][0], obstacle
s[i][1]) 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 返回从原点到机器人的最大欧式距离的平方。   
示例 1： 输入: commands = [4,-1,3], obstacles = [] 输出: 25 解释: 机器人将会到达 (3, 4)  示例 2： 输
入: commands = [4,-1,4,-2,4], obstacles = [[2,4]] 输出: 65 解释: 机器人在左转走到 (1, 8) 之前将被
困在 (1, 4) 处    提示：  	0 	0 	-30000 	-30000 	答案保证小于 2 ^ 31
*/

 java.util.HashSet;

public class L874Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] directionX = new int[]{0, 1, 0, -1};
        int[] directionY = new int[]{1, 0, -1, 0};

        HashSet<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int directionIndex = 0;
        int x = 0;
        int y = 0;
        int maxDistance = 0;

        for (int command : commands) {
            if (command == -2) {
                directionIndex = (directionIndex + 3) % 4;
            } else if (command == -1) {
                directionIndex = (directionIndex + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nextX = x + directionX[directionIndex];
                    int nextY = y + directionY[directionIndex];
                    String obstacleString = nextX + "," + nextY;
                    if (obstacleSet.contains(obstacleString)) {
                        break;
                    }
                    x = nextX;
                    y = nextY;
                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        L874Solution solution = new L874Solution();

        int[] commands1 = new int[]{4, -1, 3};
        int[][] obstacles1 = new int[][]{};
        System.out.println(solution.robotSim(commands1, obstacles1));

        int[] commands2 = new int[]{4, -1, 4, -2, 4};
        int[][] obstacles2 = new int[][]{{2, 4}};
        System.out.println(solution.robotSim(commands2, obstacles2));
    }
} 