package com.sky.algorithmleetcode;

/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 说明：解集不能包含重复的子集。 示例: 输入: [1,2,2] 输出: [  
[2],  [1],  [1,2,2],  [2,2],  [1,2],  [] ]
*/

 java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); //排序
        backTracking(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            //剪枝，避免重复
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            backTracking(res, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        L90Solution solution = new L90Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
} 