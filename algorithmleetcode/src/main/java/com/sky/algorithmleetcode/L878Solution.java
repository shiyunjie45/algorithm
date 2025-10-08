package com.sky.algorithmleetcode;

/*
如果正整数可以被 A 或 B 整除，那么它是神奇的。 返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。     示例 1： 输入
：N = 1, A = 2, B = 3 输出：2  示例 2： 输入：N = 4, A = 2, B = 3 输出：6  示例 3： 输入：N = 5, A 
= 2, B = 4 输出：10  示例 4： 输入：N = 3, A = 6, B = 4 输出：8    提示：  	1 	2 	2
*/

以下是L878Solution的Java代码实现：

class L878Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        // 求 A 和 B 的最小公倍数
        long lcm = LCM(A, B);

        // 求每 lcm 个数里有多少个神奇数
        long magicCountInEachLcm = A / GCD(A,B) * B; 

        // 计算 lcm 数组的大小
        long lcmArraySize = lcm / magicCountInEachLcm;

        // 计算 N 在 lcm 数组的哪一个位置
        long position = N / lcmArraySize;

        // 得出当前位置的数值
        long res = position * lcm;

        N %= lcmArraySize; // 计算剩余的位置
        if (N == 0) return (int)(res % 1000000007);

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.add(A);
        minHeap.add(B);

        for (long i = 1; i < N; i++) {
            long currMin = minHeap.poll();
            res += currMin;
            minHeap.offer(currMin + Math.min(currMin, A) == A ? B : A);
        }

        return (int)(res % 1000000007);
    }

    // 求最小公倍数
    public long LCM(int a, int b) {
        return (long)a * (long)b / GCD(a, b);
    }

    // 求最大公约数
    public int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
} 