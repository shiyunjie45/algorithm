package com.sky.algorithmleetcode;

/*
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​ 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一
支股票）:  	你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 	卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。  示例: 输入:
 [1,2,3,0,2] 输出: 3 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
*/

 class L309Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for(int i = 1;i < n;i++) {
            int[] maxProfit = new int[3];
            maxProfit[0] = f[i - 1][2] - prices[i];
            maxProfit[1] = f[i - 1][0] + prices[i];
            maxProfit[2] = Math.max(f[i - 1][1],f[i - 1][2]);
            f[i][0] = Math.max(maxProfit[0],f[i - 1][0]);
            f[i][1] = Math.max(maxProfit[1],f[i - 1][1]);
            f[i][2] = Math.max(maxProfit[2],f[i - 1][2]);
        }
        return Math.max(f[n - 1][1],f[n - 1][2]);
    }
} 