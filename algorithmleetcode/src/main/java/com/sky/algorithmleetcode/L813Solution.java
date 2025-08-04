package com.sky.algorithmleetcode;

/*
我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。 注意我们必须使用 A 数组
中的每一个数进行分组，并且分数不一定需要是整数。  示例: 输入: A = [9,1,2,3,9] K = 3 输出: 20 解释: A 的最优分组是[9], 
[1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20. 我们也可以把 A 分成[9, 1], [2], [3,
 9]. 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.  说明:  	1 . 	1 . 	1 . 	答案误差在 10^-6 内被视为是
正确的。
*/

 class L813Solution {

    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] dp = new double[n+1][k+1];
        double[] sum = new double[n+1];

        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
            dp[i][1] = sum[i] / i;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 2; j <= k; j++) {
                for(int l = j-1; l < i; l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[l][j-1] + (sum[i]-sum[l]) / (i-l));
                }
            }
        }

        return dp[n][k];
    }
} 