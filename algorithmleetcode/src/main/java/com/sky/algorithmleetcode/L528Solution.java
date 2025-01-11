package com.sky.algorithmleetcode;

/*
给定一个正整数数组 w ，其中 w[i] 代表位置 i 的权重，请写一个函数 pickIndex ，它可以随机地获取位置 i，选取位置 i 的概率与 w[i] 
成正比。 说明:  	1 	1 	pickIndex 将被调用不超过 10000 次  示例1:  输入: ["Solution","pickIndex"] [
[[1]],[]] 输出: [null,0]  示例2:  输入: ["Solution","pickIndex","pickIndex","pickIndex
","pickIndex","pickIndex"] [[[1,3]],[],[],[],[],[]] 输出: [null,0,1,1,1,0] 输入语法说明：
 输入是两个列表：调用成员函数名和调用的参数。Solution 的构造函数有一个参数，即数组 w。pickIndex 没有参数。输入参数是一个列表，即使参数为空
，也会输入一个 [] 空列表。
*/

 java.util.Random;

public class L528Solution {
    private int[] preSum;
    private int totalSum;
    private Random rand;

    public L528Solution(int[] w) {
        preSum = new int[w.length];
        rand = new Random();

        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            preSum[i] = totalSum;
        }
    }

    public int pickIndex() {
        int target = rand.nextInt(totalSum);
        int start = 0, end = preSum.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (preSum[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (preSum[start] > target) {
            return start;
        } else {
            return end;
        }
    }
} 