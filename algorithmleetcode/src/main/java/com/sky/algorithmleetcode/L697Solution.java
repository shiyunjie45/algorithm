package com.sky.algorithmleetcode;

/*
给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。 你的任务是找到与 nums 拥有相同大小的度的最短连续子数
组，返回其长度。 示例 1:  输入: [1, 2, 2, 3, 1] 输出: 2 解释: 输入数组的度是2，因为元素1和2的出现频数最大，均为2. 连续子数组
里面拥有相同度的有如下所示: [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3]
, [2, 2] 最短连续子数组[2, 2]的长度为2，所以返回2.  示例 2:  输入: [1,2,2,3,1,4,2] 输出: 6  注意:  	nums
.length 在1到50,000区间范围内。 	nums[i] 是一个在0到49,999范围内的整数。
*/

 java.util.HashMap;
import java.util.Map;

public class L697Solution {
    public int findShortestSubArray(int[] nums) {
        // 存储数字出现的频次
        Map<Integer, Integer> countMap = new HashMap<>();
        // 存储数字第一次出现的位置
        Map<Integer, Integer> firstMap = new HashMap<>();
        int degree = 0;
        int minLength = nums.length;
        // 遍历数组，统计数字出现的频次和位置
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 如果数字第一次出现，则记录其位置
            if (!firstMap.containsKey(num)) {
                firstMap.put(num, i);
            }
            // 统计数字出现的频次
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            // 如果当前数字出现的频次大于degree，则更新degree
            if (countMap.get(num) > degree) {
                degree = countMap.get(num);
            }
        }
        // 遍历所有出现频次为degree的数字，计算最短子数组长度
        for (int num : countMap.keySet()) {
            if (countMap.get(num) == degree) {
                minLength = Math.min(minLength, i - firstMap.get(num) + 1);
            }
        }
        return minLength;
    }
} 