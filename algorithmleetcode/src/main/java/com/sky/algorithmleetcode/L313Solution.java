package com.sky.algorithmleetcode;

/*
编写一段程序来查找第 n 个超级丑数。 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。 示例: 输入: n = 12, prim
es = [2,7,13,19] 输出: 32 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,
2,4,7,8,13,14,16,19,26,28,32] 。 说明:  	1 是任何给定 primes 的超级丑数。 	 给定 primes 中的数字以升序排
列。 	0 k ≤ 100, 0 n ≤ 106, 0 primes[i] 	第 n 个超级丑数确保在 32 位有符整数范围内。
*/

 class L313Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] indexArr = new int[primes.length];
        int[] uglyArr = new int[n];
        uglyArr[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * uglyArr[indexArr[j]]);
            }
            uglyArr[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == primes[j] * uglyArr[indexArr[j]]) {
                    indexArr[j]++;
                }
            }
        }
        return uglyArr[n - 1];
    }
} 