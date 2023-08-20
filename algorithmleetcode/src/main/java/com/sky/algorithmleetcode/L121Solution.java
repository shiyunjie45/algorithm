package com.sky.algorithmleetcode;

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利
润。 注意：你不能在买入股票前卖出股票。   示例 1: 输入: [7,1,5,3,6,4] 输出: 5 解释: 在第 2 天（股票价格 = 1）的时候买入，在
第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。   注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买
入前卖出股票。  示例 2: 输入: [7,6,4,3,1] 输出: 0 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
*/

 class L121Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0]; // 最小价格
        int maxProfit = 0; // 最大利润
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) { // 如果当前价格小于最小价格，则更新最小价格
                minPrice = prices[i];
            } else {
                int currProfit = prices[i] - minPrice; // 计算当前价格卖出的利润
                if (currProfit > maxProfit) { // 如果当前利润大于最大利润，则更新最大利润
                    maxProfit = currProfit;
                }
            }
        }
        return maxProfit;
    }
} 