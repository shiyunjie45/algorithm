package com.sky.algorithmleetcode;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 说明：解集不能包含重复的子集。 示例: 输入: nums = [1,2,3] 输出
: [  [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
*/

 java.util.ArrayList;
import java.util.List;

public class L78Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        res.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
} 