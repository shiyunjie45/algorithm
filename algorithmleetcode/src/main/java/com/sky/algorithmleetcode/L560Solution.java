package com.sky.algorithmleetcode;

/*
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 示例 1 :  输入:nums = [1,1,1], k = 2 输出: 2
 , [1,1] 与 [1,1] 为两种不同的情况。  说明 :  	数组的长度为 [1, 20,000]。 	数组中元素的范围是 [-1000, 1000] 
，且整数 k 的范围是 [-1e7, 1e7]。
*/

import java.util.HashMap;
import java.util.Map;

public class L560Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
} 