package com.sky.algorithmleetcode;

/*
给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums
[i] 的元素的数量。 示例: 输入: [5,2,6,1] 输出: [2,1,1,0] 解释: 5 的右侧有 2 个更小的元素 (2 和 1). 2 的右侧仅有
 1 个更小的元素 (1). 6 的右侧有 1 个更小的元素 (1). 1 的右侧有 0 个更小的元素.
*/

import java.util.*;

public class L315Solution {
    private int[] temp;
    private int[] counts;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int len = nums.length;
        temp = new int[len];
        counts = new int[len];
        int[] indexes = new int[len];
        for(int i = 0; i < len; ++i){
            indexes[i] = i;
        }
        mergeSort(nums, indexes, 0, len - 1);
        for(int i = 0; i < len; ++i){
            res.add(counts[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] indexes, int begin, int end){
        if(begin >= end) return;
        int mid = begin + ((end - begin) >> 1);
        mergeSort(nums, indexes, begin, mid);
        mergeSort(nums, indexes, mid + 1, end);
        merge(nums, indexes, begin, mid, end);
    }

    private void merge(int[] nums, int[] indexes, int begin, int mid, int end){
        int i = begin;
        int j = mid + 1;
        int k = begin;
        while(i <= mid && j <= end){
            if(nums[indexes[i]] > nums[indexes[j]]){
                counts[indexes[i]] += end - j + 1;
                temp[k++] = indexes[i++];
            } else {
                temp[k++] = indexes[j++];
            }
        }
        while(i <= mid) temp[k++] = indexes[i++];
        while(j <= end) temp[k++] = indexes[j++];
        System.arraycopy(temp, begin, indexes, begin, end - begin + 1);
    }
} 