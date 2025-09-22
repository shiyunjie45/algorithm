package com.sky.algorithmleetcode;

/*
返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。 如果没有和至少为 K 的非空子数组，返回 -1 。     示例 1： 输入：A = [1]
, K = 1 输出：1  示例 2： 输入：A = [1,2], K = 4 输出：-1  示例 3： 输入：A = [2,-1,2], K = 3 输出：3
    提示：  	1 	-10 ^ 5  	1
*/

 java.util.*;

public class L862Solution {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = A[i - 1] + sum[i - 1];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int ans = n + 1;
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && sum[i] - sum[deque.getFirst()] >= K) {
                ans = Math.min(ans, i - deque.removeFirst());
            }
            while (!deque.isEmpty() && sum[i] <= sum[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        return ans == n + 1 ? -1 : ans;
    }
} 