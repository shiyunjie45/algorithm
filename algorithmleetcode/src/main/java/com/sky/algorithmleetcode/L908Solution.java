package com.sky.algorithmleetcode;

/*
给你一个整数数组 A，对于每个整数 A[i]，我们可以选择处于区间 [-K, K] 中的任意数 x ，将 x 与 A[i] 相加，结果存入 A[i] 。 在此过
程之后，我们得到一些数组 B。 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。     示例 1： 输入：A = [1], K = 0 输出：0 解
释：B = [1]  示例 2： 输入：A = [0,10], K = 2 输出：6 解释：B = [2,8]  示例 3： 输入：A = [1,3,6], K
 = 3 输出：0 解释：B = [3,3,3] 或 B = [4,4,4]    提示：  	1 	0 	0
*/

 java.util.Arrays;

public class L908Solution {
    public int smallestRangeI(int[] A, int K) {
        // 如果A数组的长度为1，则最小差值为0
        if (A.length == 1) {
            return 0;
        }
        // 对A数组进行排序
        Arrays.sort(A);
        // 计算B数组的最大值和最小值
        int maxB = A[A.length - 1] - K;
        int minB = A[0] + K;
        // 如果B数组的最大值小于等于最小值，则最小差值为0
        if (maxB <= minB) {
            return 0;
        }
        // 否则，最小差值为B数组的最大值减去最小值
        return maxB - minB;
    }
} 