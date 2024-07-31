package com.sky.algorithmleetcode;

/*
给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k  个数字拼接成一个新的数，要求从同
一个数组中取出的数字保持其在原数组中的相对顺序。 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。 说明: 请尽可能地优化你算法的时间和空间
复杂度。 示例 1: 输入: nums1 = [3, 4, 6, 5] nums2 = [9, 1, 2, 5, 8, 3] k = 5 输出: [9, 8, 
6, 5, 3] 示例 2: 输入: nums1 = [6, 7] nums2 = [6, 0, 4] k = 5 输出: [6, 7, 6, 0, 4] 示例
 3: 输入: nums1 = [3, 9] nums2 = [8, 9] k = 3 输出: [9, 8, 9]
*/

import java.util.*;

public class L321Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] seq1 = maxSeq(nums1, i);
            int[] seq2 = maxSeq(nums2, k - i);
            int[] seq = merge(seq1, seq2);
            if (greater(seq, 0, res, 0))
                res = seq;
        }
        return res;
    }

    private int[] maxSeq(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && res[j - 1] < nums[i])
                j--;
            if (j < k)
                res[j++] = nums[i];
        }
        return res;
    }

    private int[] merge(int[] seq1, int[] seq2) {
        int m = seq1.length, n = seq2.length;
        if (m == 0) return seq2;
        if (n == 0) return seq1;
        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            res[k++] = greater(seq1, i, seq2, j) ? seq1[i++] : seq2[j++];
        }
        while (i < m) res[k++] = seq1[i++];
        while (j < n) res[k++] = seq2[j++];
        return res;
    }

    private boolean greater(int[] seq1, int i, int[] seq2, int j) {
        while (i < seq1.length && j < seq2.length && seq1[i] == seq2[j]) {
            i++;
            j++;
        }
        return j == seq2.length || (i < seq1.length && seq1[i] > seq2[j]);
    }
} 