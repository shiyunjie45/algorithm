package com.sky.algorithmleetcode;

/*
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 说明：  	所有数字都是正整数。 	解集不
能包含重复的组合。   示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]  示例 2: 输入: k = 3, n = 9 输出: [[1
,2,6], [1,3,5], [2,3,4]]
*/

import java.util.ArrayList;
import java.util.List;

public class L216Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 1);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int k, int remain, int start) {
        if (tempList.size() == k && remain == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        if (tempList.size() > k || remain < 0) return;
        for (int i = start; i <= 9; i++) {
            tempList.add(i);
            backtrack(res, tempList, k, remain - i, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
} 