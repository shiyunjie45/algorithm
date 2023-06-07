package com.sky.algorithmleetcode;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。 示例: 输入: [1,2,3] 输出: [  [1,2,3],  [1,3,2],  [2,1,3],
  [2,3,1],  [3,1,2],  [3,2,1] ]
*/

import java.util.ArrayList;
import java.util.List;

public class L46Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), nums);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                helper(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
} 