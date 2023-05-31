package com.sky.algorithmleetcode;

/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 candidates
 中的每个数字在每个组合中只能使用一次。 说明：  	所有数字（包括目标数）都是正整数。 	解集不能包含重复的组合。   示例 1: 输入: candidate
s = [10,1,2,7,6,1,5], target = 8, 所求解集为: [  [1, 7],  [1, 2, 5],  [2, 6],  [1, 1,
 6] ]  示例 2: 输入: candidates = [2,5,2,1,2], target = 5, 所求解集为: [   [1,2,2],   [5]
 ]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new boolean[candidates.length], new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int index, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            if (target < candidates[i]) {
                break;
            }
            used[i] = true;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
} 