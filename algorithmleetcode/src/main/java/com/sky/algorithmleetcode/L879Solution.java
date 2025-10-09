package com.sky.algorithmleetcode;

/*
帮派里有 G 名成员，他们可能犯下各种各样的罪行。 第 i 种犯罪会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。 让我们把这些犯
罪的任何子集称为盈利计划，该计划至少产生 P 的利润。 有多少种方案可以选择？因为答案很大，所以返回它模 10^9 + 7 的值。   示例 1： 输入：G =
 5, P = 3, group = [2,2], profit = [2,3] 输出：2 解释： 至少产生 3 的利润，该帮派可以犯下罪 0 和罪 1 ，或仅
犯下罪 1 。 总的来说，有两种方案。  示例 2: 输入：G = 10, P = 5, group = [2,3,5], profit = [6,7,8] 输
出：7 解释： 至少产生 5 的利润，只要他们犯其中一种罪就行，所以该帮派可以犯下任何罪行 。 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,
2)，(1,2)，以及 (0,1,2) 。    提示：  	1 	0 	1 	0 	1
*/

 class L879Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] dp = new int[P + 1][G + 1];
        dp[0][0] = 1;
        int mod = (int) Math.pow(10, 9) + 7;

        for (int k = 0; k < group.length; k++) {
            int g = group[k];
            int p = profit[k];
            for (int i = P; i >= 0; i--) {
                for (int j = G - g; j >= 0; j--) {
                    int profitNeeded = Math.min(i + p, P);
                    dp[profitNeeded][j + g] = (dp[profitNeeded][j + g] + dp[i][j]) % mod;
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= G; i++) {
            result = (result + dp[P][i]) % mod;
        }

        return result;
    }
} 