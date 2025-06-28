package com.sky.algorithmleetcode;

/*
在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示. 一次移动定义为选择 0 与一个相邻的数字（上下左
右）进行交换. 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如
果不能解开谜板，则返回 -1 。 示例：  输入：board = [[1,2,3],[4,0,5]] 输出：1 解释：交换 0 和 5 ，1 步完成  输入：b
oard = [[1,2,3],[5,4,0]] 输出：-1 解释：没有办法完成谜板  输入：board = [[4,1,2],[5,0,3]] 输出：5 解释
： 最少完成谜板的最少移动次数是 5 ， 一种移动路径: 尚未移动: [[4,1,2],[5,0,3]] 移动 1 次: [[4,1,2],[0,5,3]] 移
动 2 次: [[0,1,2],[4,5,3]] 移动 3 次: [[1,0,2],[4,5,3]] 移动 4 次: [[1,2,0],[4,5,3]] 移动 
5 次: [[1,2,3],[4,5,0]]  输入：board = [[3,2,4],[1,5,0]] 输出：14  提示：  	board 是一个如上所述的
 2 x 3 的数组. 	board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
*/

 java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L773Solution {

    public int slidingPuzzle(int[][] board) {
        int m = 2, n = 3;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String target = "123450";
        if (start.equals(target)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(start);
        set.add(start);
        int[] dir = new int[]{-1, 1, -3, 3}; // 上下左右四个方向
        int step = 0; // 步数
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int idx = curr.indexOf('0'); // 找到数字0的位置
                int x = idx / n;
                int y = idx % n;
                for (int j = 0; j < 4; j++) {
                    int newX = x + dir[j];
                    int newY = y + dir[j];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        int newIdx = newX * n + newY;
                        // 交换数字0和相邻的数字
                        char[] ch = curr.toCharArray();
                        char temp = ch[idx];
                        ch[idx] = ch[newIdx];
                        ch[newIdx] = temp;
                        String next = new String(ch);
                        if (set.contains(next)) {
                            continue;
                        }
                        if (next.equals(target)) {
                            return step + 1;
                        }
                        queue.offer(next);
                        set.add(next);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] board1 = {{1,2,3},{4,0,5}};
        int[][] board2 = {{1,2,3},{5,4,0}};
        int[][] board3 = {{4,1,2},{5,0,3}};
        int[][] board4 = {{3,2,4},{1,5,0}};
        L773Solution solution = new L773Solution();
        System.out.println(solution.slidingPuzzle(board1)); // 1
        System.out.println(solution.slidingPuzzle(board2)); // -1
        System.out.println(solution.slidingPuzzle(board3)); // 5
        System.out.println(solution.slidingPuzzle(board4)); // 14
    }
} 