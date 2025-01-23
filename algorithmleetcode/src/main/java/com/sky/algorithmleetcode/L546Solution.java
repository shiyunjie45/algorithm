package com.sky.algorithmleetcode;

/*
给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色
的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。 当你将所有盒子都去掉之后，求你能获得的最大积分和。 示例 1： 输入:  [1, 3
, 2, 2, 2, 3, 4, 3, 1]  输出:  23  解释:  [1, 3, 2, 2, 2, 3, 4, 3, 1] ----> [1, 3, 3
, 4, 3, 1] (3*3=9 分) ----> [1, 3, 3, 3, 1] (1*1=1 分) ----> [1, 1] (3*3=9 分) ----
> [] (2*2=4 分)    提示：盒子的总数 n 不会超过 100。
*/

 class L546Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];// 转移需要三个参数, 故设dp数组为三维
        return calculatePoints(boxes, dp, 0, n - 1, 0);
    }
    private int calculatePoints(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r) return 0;
        if (dp[l][r][k] != 0)
            return dp[l][r][k];
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }
        dp[l][r][k] = calculatePoints(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1);
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(boxes, dp, l, i, k + 1) + calculatePoints(boxes, dp, i + 1, r - 1, 0));
            }
        }
        return dp[l][r][k];
    }
} 