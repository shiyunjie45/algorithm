package com.sky.algorithmleetcode;

/*
给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄
罗斯套娃一样。 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 说明: 不允许旋转信封。 示例: 输入: enve
lopes = [[5,4],[6,4],[6,7],[2,3]] 输出: 3 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [
6,7]。
*/

import java.util.Arrays;
import java.util.Comparator;

public class L354Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        // 按照宽度从小到大排序，如果宽度相同则按照高度从大到小排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        // 对高度数组寻找LIS
        int n = envelopes.length;
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    // LeetCode 300题：最长上升子序列
    private int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
} 