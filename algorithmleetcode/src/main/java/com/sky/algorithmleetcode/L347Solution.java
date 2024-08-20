package com.sky.algorithmleetcode;

/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。   示例 1: 输入: nums = [1,1,1,2,2,3], k = 2 输出: [1,2] 
 示例 2: 输入: nums = [1], k = 1 输出: [1]   提示：  	你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元
素的个数。 	你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 	题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一
的。 	你可以按任意顺序返回答案。
*/

import java.util.*;

public class L347Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 统计每个元素出现的频率
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 使用桶排序，将频率相同的元素放在同一个桶中
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        // 从后往前遍历桶，取出前k个高频元素
        int[] result = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) {
                        break;
                    }
                }
            }
        }
        return result;
    }
} 