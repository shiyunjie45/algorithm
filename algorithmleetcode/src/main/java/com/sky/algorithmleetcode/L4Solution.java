package com.sky.algorithmleetcode;

import java.text.DecimalFormat;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * Related Topics
 * 数组
 * 二分查找
 * 分治
 */
public class L4Solution {
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;  // 取左右中位数
        // 将两个数组进行合并，从中找到第 left 小的数和第 right 小的数，然后求平均值即可得到中位数
        return ((long)getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) + (long)getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) / 2.0;
    }

    static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        // 确保 nums1 的长度小于 nums2 的长度，这样就能保证如果有数组空了，一定是 nums1
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        // 如果 nums1 为空，直接从 nums2 中找到第 k 小的数
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        // 如果 k = 1，则返回两个数组的最小值
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        // 如果 k/2 大于 nums1 的长度，则将 nums1 的长度设为 k/2
        int i = start1 + Math.min(len1, k/2) - 1;
        int j = start2 + Math.min(len2, k/2) - 1;
        // 比较 nums1 和 nums2 的第 k/2 个数，如果 nums1 的数小，则说明 nums1 的前 k/2 个数不可能为第 k 小的数，将其排除，然后在排除后的 nums1 和 nums2 中继续查找第 k 小的数
        if (nums1[i] < nums2[j]) {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        } else {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
    }

    public static void main(String[] args){
        DecimalFormat doubleFormat = new DecimalFormat();
        doubleFormat.setMaximumFractionDigits(2);
        doubleFormat.setGroupingUsed(false);
        Utils utils = new Utils();
        utils.setStartTime();
        for (int i = 0; i < 100; i++) {
            int[] arr1 = Utils.generateRandomSortedArray(10,0, Integer.MAX_VALUE);
            int[] arr2 = Utils.generateRandomSortedArray(10,0, Integer.MAX_VALUE);
            double middleNum=findMedianSortedArrays(arr1,arr2);
            System.out.println("数组:"+Utils.arrayToString(arr1));
            System.out.println("数组:"+Utils.arrayToString(arr2));
            System.out.println("中位数是:"+doubleFormat.format(middleNum));
        }
        utils.printTimeConsuming();
    }
}
