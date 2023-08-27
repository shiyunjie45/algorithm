package com.sky.algorithmleetcode;

/*
给定一个未排序的整数数组，找出最长连续序列的长度。 要求算法的时间复杂度为 O(n)。 示例: 输入: [100, 4, 200, 1, 3, 2] 输出: 4
 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
*/

import java.util.HashMap;

public class L128Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxLen = 1;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                continue;
            }
            int left = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
            int right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
            int sum = left + right + 1;
            map.put(nums[i], sum);
            maxLen = Math.max(maxLen, sum);
            map.put(nums[i] - left, sum);
            map.put(nums[i] + right, sum);
        }
        return maxLen;
    }
} 