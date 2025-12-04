package com.sky.algorithmleetcode;

/*
国际象棋中的骑士可以按下图所示进行移动：  .             这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳
 N-1 步。每一步必须是从一个数字键跳到另一个数字键。 每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N 位数字。 你能用这种方
式拨出多少个不同的号码？ 因为答案可能很大，所以输出答案模 10^9 + 7。     示例 1： 输入：1 输出：10  示例 2： 输入：2 输出：20  
示例 3： 输入：3 输出：46    提示：  	1
*/

/**
 * LeetCode 935. 骑士拨号器
 */
public class L935Solution {

    private static final int[][] DIRECTION = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};

    public int knightDialer(int n) {
        long[][] dp = new long[n][10];
        int mod = 1000000007;
        Arrays.fill(dp[0], 1);
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < 10; i++) {
                for (int[] d : DIRECTION) {
                    int x = i / 3 + d[0];
                    int y = i % 3 + d[1];
                    if (x >= 0 && x < 4 && y >= 0 && y < 3 && !(x == 3 && (y == 0 || y == 2))) {
                        dp[k][i] += dp[k - 1][x * 3 + y];
                        dp[k][i] %= mod;
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[n - 1][i];
            ans %= mod;
        }
        return (int) ans;
    }
} 