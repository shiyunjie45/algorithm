package com.sky.algorithmleetcode;

/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。 示例: 输入: [1,1,2] 输出: [  [1,1,2],  [1,2,1],  [2,1,1] ]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L47Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, res, new ArrayList<Integer>(), used);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tempList, boolean[] used) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            tempList.add(nums[i]);
            used[i] = true;
            backtrack(nums, res, tempList, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
} 