package com.sky.algorithmleetcode;

/*
给定一个整数 n, 返回从 1 到 n 的字典顺序。 例如， 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。 请尽
可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
*/

import java.util.ArrayList;
import java.util.List;

public class L386Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private void dfs(int cur, int n, List<Integer> result) {
        if (cur > n) {
            return;
        }
        result.add(cur);
        for (int i = 0; i <= 9; i++) {
            int next = cur * 10 + i;
            if (next > n) {
                return;
            }
            dfs(next, n, result);
        }
    }

} 