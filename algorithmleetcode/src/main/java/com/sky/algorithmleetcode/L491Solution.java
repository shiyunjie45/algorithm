package com.sky.algorithmleetcode;

/*
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。 示例:  输入: [4, 6, 7, 7] 输出: [[4, 6], [4
, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]] 说明:  	给定数组的长度不
会超过15。 	数组中的整数范围是 [-100,100]。 	给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
*/

 java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L491Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        boolean[] used = new boolean[201];
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if (used[num + 100]) {
                continue;
            }
            if (path.isEmpty() || num >= path.get(path.size() - 1)) {
                used[num + 100] = true;
                path.add(num);
                dfs(nums, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        L491Solution solution = new L491Solution();
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> res = solution.findSubsequences(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
} 