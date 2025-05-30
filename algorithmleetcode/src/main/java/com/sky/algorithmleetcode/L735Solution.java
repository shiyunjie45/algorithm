package com.sky.algorithmleetcode;

/*
给定一个整数数组 asteroids，表示在同一行的行星。 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移
动）。每一颗行星以相同的速度移动。 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方
向相同的行星，永远不会发生碰撞。 示例 1:  输入: asteroids = [5, 10, -5] 输出: [5, 10] 解释: 10 和 -5 碰撞后只
剩下 10。 5 和 10 永远不会发生碰撞。  示例 2:  输入: asteroids = [8, -8] 输出: [] 解释: 8 和 -8 碰撞后，两者
都发生爆炸。  示例 3:  输入: asteroids = [10, 2, -5] 输出: [10] 解释: 2 和 -5 发生碰撞后剩下 -5。10 和 -
5 发生碰撞后剩下 10。  示例 4:  输入: asteroids = [-2, -1, 1, 2] 输出: [-2, -1, 1, 2] 解释: -2 和
 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。  说明:  	数组 asteroids 的长度不超
过 10000。 	每一颗行星的大小都是非零整数，范围是 [-1000, 1000] 。
*/

 java.util.Stack;

public class L735Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>(); // 用栈来实现碰撞

        for(int asteroid : asteroids) {
            // 处理向左移动的行星碰撞
            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0 && stack.peek() < -asteroid) {
                stack.pop(); // 左边的行星爆炸
            }
            if(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0 && stack.peek() == -asteroid) {
                stack.pop(); // 两个行星大小相同，都爆炸
            } 
            else if(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0 && stack.peek() > -asteroid) {
              // 右边的行星爆炸
            }
            else {
                stack.push(asteroid); // 没有碰撞，入栈
            }
        }

        // 将栈转换为数组
        int[] result = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
} 