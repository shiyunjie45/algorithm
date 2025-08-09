package com.sky.algorithmleetcode;

/*
你的赛车起始停留在位置 0，速度为 +1，正行驶在一个无限长的数轴上。（车也可以向负数方向行驶。） 你的车会根据一系列由 A（加速）和 R（倒车）组成的指令进行
自动驾驶 。 当车得到指令 "A" 时, 将会做出以下操作： position += speed, speed *= 2。 当车得到指令 "R" 时, 将会做出
以下操作：如果当前速度是正数，则将车速调整为 speed = -1 ；否则将车速调整为 speed = 1。  (当前所处位置不变。) 例如，当得到一系列指令 
"AAR" 后, 你的车将会走过位置 0->1->3->3，并且速度变化为 1->2->4->-1。 现在给定一个目标位置，请给出能够到达目标位置的最短指令列表
的长度。 示例 1: 输入: target = 3 输出: 2 解释: 最短指令列表为 "AA" 位置变化为 0->1->3  示例 2: 输入: target
 = 6 输出: 5 解释: 最短指令列表为 "AAARA" 位置变化为 0->1->3->7->7->6  说明:  	1 。
*/

 java.util.*;

public class L818Solution {
    public int racecar(int target) {
        // 使用一个Set记录已经出现过的位置和速度
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1});
        visited.add("0,1");

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int pos = curr[0], speed = curr[1];

                if (pos == target) {
                    return level;
                }

                // 尝试加速行驶
                int[] next1 = new int[]{pos + speed, speed * 2};
                if (!visited.contains(next1[0] + "," + next1[1]) && next1[0] > 0 && next1[0] < (target * 2)) {
                    queue.offer(next1);
                    visited.add(next1[0] + "," + next1[1]);
                }

                // 尝试倒车行驶
                int[] next2 = new int[]{pos, speed > 0 ? -1 : 1};
                if (!visited.contains(next2[0] + "," + next2[1]) && next2[0] > 0 && next2[0] < (target * 2)) {
                    queue.offer(next2);
                    visited.add(next2[0] + "," + next2[1]);
                }
            }
            level++;
        }

        return -1; // 无法到达目标位置
    }
} 