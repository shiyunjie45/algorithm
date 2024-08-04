package com.sky.algorithmleetcode;

/*
给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。 区间和 S(i, j) 表示在 nums
 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。 说明: 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。 示例: 输入:
 nums = [-2,5,-1], lower = -2, upper = 2, 输出: 3 解释: 3个区间分别是: [0,0], [2,2], [0,2]
，它们表示的和分别为: -2, -1, 2。
*/

import java.util.*;

public class L327Solution {
    private int count = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] preSum = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        mergeSort(preSum, 0, preSum.length-1, lower, upper);
        return count;
    }

    private void mergeSort(long[] preSum, int left, int right, int lower, int upper) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(preSum, left, mid, lower, upper);
        mergeSort(preSum, mid+1, right, lower, upper);
        int lo = mid+1, hi = mid+1;
        for (int i = left; i <= mid; i++) {
            while (lo <= right && preSum[lo] - preSum[i] < lower) lo++;
            while (hi <= right && preSum[hi] - preSum[i] <= upper) hi++;
            count += hi - lo;
        }
        merge(preSum, left, mid, right);
    }

    private void merge(long[] preSum, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (preSum[i] < preSum[j]) {
                temp[k++] = preSum[i++];
            } else {
                temp[k++] = preSum[j++];
            }
        }
        while (i <= mid) temp[k++] = preSum[i++];
        while (j <= right) temp[k++] = preSum[j++];
        System.arraycopy(temp, 0, preSum, left, temp.length);
    }
} 