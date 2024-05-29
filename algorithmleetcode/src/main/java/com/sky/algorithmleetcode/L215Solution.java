package com.sky.algorithmleetcode;

/*
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 示例 1: 输入: [3,2,1,
5,6,4] 和 k = 2 输出: 5  示例 2: 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4 输出: 4 说明:  你可以假设 k 总
是有效的，且 1 ≤ k ≤ 数组的长度。
*/

 class L215Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == nums.length - k) {
            return nums[pivotIndex];
        } else if (pivotIndex < nums.length - k) {
            return quickSelect(nums, pivotIndex + 1, right, k);
        } else {
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            } else if (nums[l] >= pivot) {
                l++;
            } else {
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} 