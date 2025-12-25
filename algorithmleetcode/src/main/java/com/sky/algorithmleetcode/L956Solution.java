package com.sky.algorithmleetcode;

/*
你正在安装一个广告牌，并希望它高度最大。这块广告牌将有两个钢制支架，两边各一个。每个钢支架的高度必须相等。 你有一堆可以焊接在一起的钢筋 rods。举个例子，如
果钢筋的长度为 1、2 和 3，则可以将它们焊接在一起形成长度为 6 的支架。 返回广告牌的最大可能安装高度。如果没法安装广告牌，请返回 0。   示例 1： 
输入：[1,2,3,6] 输出：6 解释：我们有两个不相交的子集 {1,2,3} 和 {6}，它们具有相同的和 sum = 6。  示例 2： 输入：[1,2,
3,4,5,6] 输出：10 解释：我们有两个不相交的子集 {2,3,5} 和 {4,6}，它们具有相同的和 sum = 10。 示例 3： 输入：[1,2] 
输出：0 解释：没法安装广告牌，所以返回 0。   提示：  	0 	1 	钢筋的长度总和最多为 5000
*/

 java.util.Arrays;

public class L956Solution {
    public int tallestBillboard(int[] rods) {
        // 计算出钢筋长度总和
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        // dp[i]表示两边钢架高度差为i时，左钢架的最大高度
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        // 遍历每个钢筋
        for (int rod : rods) {
            int[] new_dp = Arrays.copyOf(dp, dp.length);
            // 将当前钢筋分别放于左边和右边
            for (int i = 0; i <= sum - rod; i++) {
                if (dp[i] >= 0) {
                    new_dp[i + rod] = Math.max(new_dp[i + rod], dp[i]);
                    new_dp[Math.abs(i - rod)] = Math.max(new_dp[Math.abs(i - rod)], dp[i] + Math.min(i, rod));
                }
            }
            dp = new_dp;
        }
        return dp[0];
    }
} 