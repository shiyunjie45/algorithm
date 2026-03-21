package com.sky.algorithmleetcode;

/*
在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：  	"G"：直走 1 个单位 	"L"：左转 90 度 	"R"：
右转 90 度  机器人按顺序执行指令 instructions，并一直重复它们。 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 fa
lse。   示例 1： 输入："GGLLGG" 输出：true 解释： 机器人从 (0,0) 移动到 (0,2)，转 180 度，然后回到 (0,0)。 重复
这些指令，机器人将保持在以原点为中心，2 为半径的环中进行移动。  示例 2： 输入："GG" 输出：false 解释： 机器人无限向北移动。  示例 3： 输
入："GL" 输出：true 解释： 机器人按 (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ... 
进行移动。   提示：  	1 	instructions[i] 在 {'G', 'L', 'R'} 中
*/

 class L1041Solution {
    public boolean isRobotBounded(String instructions) {
        // 初始方向：北
        int x = 0, y = 0;
        int dx = 0, dy = 1;
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                // 前进一步
                x += dx;
                y += dy;
            } else if (c == 'L') {
                // 向左转
                int tmp = dy;
                dy = dx;
                dx = -tmp;
            } else {
                // 向右转
                int tmp = dx;
                dx = dy;
                dy = -tmp;
            }
        }
        // 如果最后机器人的位置是原点或者机器人的方向与初始方向不一致，就无限循环
        return x == 0 && y == 0 || dx != 0 || dy != 1;
    }
} 