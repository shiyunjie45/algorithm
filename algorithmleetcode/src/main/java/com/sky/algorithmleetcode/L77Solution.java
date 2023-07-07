package com.sky.algorithmleetcode;

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 示例: 输入: n = 4, k = 2 输出: [  [2,4],  [3,4
],  [2,3],  [1,2],  [1,3],  [1,4], ]
*/

import java.util.ArrayList;
import java.util.List;

public class L77Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }

        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, path);
        return res;
    }

    private void dfs(int n, int k, int start, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 优化：剪枝，不必遍历所有的搜索起点
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            dfs(n, k, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
} 