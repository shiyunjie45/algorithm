package com.sky.algorithmleetcode;

/*
给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。   示例 1: 输入: [0,1] 输出: 2 说明: [0, 1] 是具有
相同数量0和1的最长连续子数组。 示例 2: 输入: [0,1,0] 输出: 2 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数
组。   注意: 给定的二进制数组的长度不会超过50000。
*/

 class L525Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
} 