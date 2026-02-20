package com.sky.algorithmleetcode;

/*
给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数的个数。   示例 1： 输入：20 输出：1 解释：具有至少 1 位重复数字的正数（ 示例
 2： 输入：100 输出：10 解释：具有至少 1 位重复数字的正数（ 示例 3： 输入：1000 输出：262   
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class L1012Solution {
    public int numDupDigitsAtMostN(int N) {
        List<Integer> digits = new ArrayList<>();
        for (int x = N + 1; x > 0; x /= 10)
            digits.add(0, x % 10);

        int res = 0, n = digits.size();
        for (int i = 1; i < n; ++i)
            res += 9 * A(9, i - 1);

        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i > 0 ? 0 : 1; j < digits.get(i); ++j)
                if (!seen.contains(j))
                    res += A(9 - i, n - i - 1);
            if (seen.contains(digits.get(i))) break;
            seen.add(digits.get(i));
        }
        return N - res;
    }

    public int A(int m, int n) {
        return n == 0 ? 1 : A(m, n - 1) * (m - n + 1);
    }
}
