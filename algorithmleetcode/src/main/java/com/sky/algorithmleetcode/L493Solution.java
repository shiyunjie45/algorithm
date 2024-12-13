package com.sky.algorithmleetcode;

/*
给定一个数组 nums ，如果 i  且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 你需要返回给定数组中的重要翻转对
的数量。 示例 1:  输入: [1,3,2,3,1] 输出: 2  示例 2:  输入: [2,4,3,5,1] 输出: 3  注意:  	给定数组的长度不会
超过50000。 	输入数组中的所有数字都在32位整数的表示范围内。
*/

 class L493Solution {

    private int count;

    public int reversePairs(int[] nums) {
        count = 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if ((long) nums[i] > 2 * (long) nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        i = left;
        j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        System.arraycopy(tmp, 0, nums, left, tmp.length);
    }
} 