package com.sky.algorithmleetcode;

/*
给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。 示例 1: 输入: [0,1,2,4,5,7] 输出: ["0->2","4->5","7"] 解释
: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。 示例 2: 输入: [0,2,3,4,6,8,9] 输出: ["0","2->4","6
","8->9"] 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
*/

import java.util.ArrayList;
import java.util.List;

public class L228Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (end == nums.length - 1 || nums[end + 1] != nums[end] + 1) {
                if (start == end) {
                    result.add(String.valueOf(nums[start]));
                } else {
                    result.add(nums[start] + "->" + nums[end]);
                }
                start = end + 1;
            }
            end++;
        }
        
        return result;
    }
} 