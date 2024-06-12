package com.sky.algorithmleetcode;

/*
给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。 示例 1: 输
入: [3,2,3] 输出: [3] 示例 2: 输入: [1,1,1,3,3,2,2,2] 输出: [1,2]
*/

import java.util.ArrayList;
import java.util.List;

public class L229Solution {
    // 使用摩尔投票算法，空间复杂度为O(1)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) count1++;
            if (num == candidate2) count2++;
        }

        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);

        return result;
    }
} 