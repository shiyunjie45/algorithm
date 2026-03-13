package com.sky.algorithmleetcode;

/*
三枚石子放置在数轴上，位置分别为 a，b，c。 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x 。从位置 x 或者是位置 z 拿起一枚石子
，并将该石子移动到某一整数位置 k 处，其中 x 且 k != y。 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。 要使游戏结束，你可以执行的最
小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]   示例 1： 
输入：a = 1, b = 2, c = 5 输出：[1, 2] 解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。  示例 2：
 输入：a = 4, b = 3, c = 2 输出：[0, 0] 解释：我们无法进行任何移动。    提示：  	1 	1 	1 	a != b, b != 
c, c != a
*/

 class L1033Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        // 左边的石子移动次数
        int moveLeft = arr[1] - arr[0] - 1;
        // 右边的石子移动次数
        int moveRight = arr[2] - arr[1] - 1;
        int minMoves = 0, maxMoves = 0;
        // 如果左右两边至少有一个可以移动
        if (moveLeft > 0 || moveRight > 0) {
            // 当左右两边至少有一个石子不是相邻时，最小移动次数为1
            if (moveLeft > 0 && moveRight > 0) {
                minMoves = 1;
            } else {
                minMoves = 1;
            }
        }
        // 右边的石子向左移动或者左边的石子向右移动的时候
        // 可以留下的空位最多为2，左右各留一个
        maxMoves = moveLeft + moveRight;
        return new int[]{minMoves, maxMoves};
    }
} 