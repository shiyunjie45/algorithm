package com.sky.algorithmleetcode;

/*
给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。 示例 1: 输入: 5 输出: 5 解释: 下面是带有相应二进制表
示的非负整数 说明: 1 9
*/

 class L600Solution {
    
    public int findIntegers(int num) {
        //dp[i]表示长度为i的二进制数字不包含连续1的个数
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        int preBit = 0; //记录上一位是0还是1
        int res = 0; //用于记录总数
        for(int i=31; i>=0; i--) {
            if((num & (1 << i)) != 0) { //如果该位是1
                res += dp[i]; //加上长度为i的二进制数字不包含连续1的个数
                if(preBit == 1) { //如果上一位也是1，那么不能加1开头的数字了，直接返回结果
                    return res;
                }
                preBit = 1;
            } else { //如果该位是0
                preBit = 0;
            }
        }
        return res + 1; //要加上0这个数字
    }
} 